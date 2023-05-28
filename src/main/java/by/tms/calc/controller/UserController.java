package by.tms.calc.controller;

import by.tms.calc.dto.UserLoginDTO;
import by.tms.calc.dto.UserRegistrationDTO;
import by.tms.calc.entity.OperationHistoryPage;
import by.tms.calc.entity.SessionUser;
import by.tms.calc.entity.User;
import by.tms.calc.mapper.UserMapper;
import by.tms.calc.service.CalculatorService;
import by.tms.calc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * @author Andrei Lisouski (Andrlis) - 22/05/2023 - 21:54
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    CalculatorService calculatorService;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "registration";
    }

    @PostMapping("/register")
    public String register(@Valid UserRegistrationDTO userRegistrationDTO,
                           BindingResult bindingResult,
                           Model model) {
        if (bindingResult.hasErrors()) {
            setValidationErrors(bindingResult, model);
            return "registration";
        }
        userService.save(userRegistrationDTO);
        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(@Valid UserLoginDTO userLoginDTO,
                        BindingResult bindingResult,
                        HttpSession httpSession,
                        Model model) {
        if (bindingResult.hasErrors()) {
            setValidationErrors(bindingResult, model);
            model.addAttribute("newUser", userLoginDTO);
            return "login";
        }

        Optional<User> authenticatedUser = userService.loginUser(userLoginDTO);
        if (authenticatedUser.isPresent()){
            SessionUser sessionUser = UserMapper.toSessionUser(authenticatedUser.get());
            httpSession.setAttribute("user", sessionUser);
            return "redirect:/";
        }
        else {
            model.addAttribute("unsuccessfulLogin", "Username or password is not valid");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession) {
        httpSession.invalidate();
        return "home";
    }

    private void setValidationErrors(BindingResult bindingResult, Model model) {
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            model.addAttribute(fieldError.getField(), fieldError.getDefaultMessage());
        }
    }

    @GetMapping("/history")
    public String history(HttpSession httpSession, Model model) {
        SessionUser sessionUser = (SessionUser)httpSession.getAttribute("user");
        OperationHistoryPage historyPage = calculatorService.getHistoryPage(1, sessionUser);

        model.addAttribute("page", historyPage);
        return "history";
    }

    @GetMapping("/history/page/{pageNumber}")
    public String historyByPage(@PathVariable("pageNumber") int pageNumber, HttpSession httpSession, Model model){
        SessionUser sessionUser = (SessionUser)httpSession.getAttribute("user");
        OperationHistoryPage historyPage = calculatorService.getHistoryPage(pageNumber, sessionUser);

        model.addAttribute("page", historyPage);
        return "history";
    }
}
