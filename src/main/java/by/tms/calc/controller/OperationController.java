package by.tms.calc.controller;

import by.tms.calc.dto.OperationCreationDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Andrei Lisouski (Andrlis) - 22/05/2023 - 21:54
 */
@Controller
@RequestMapping("/operation")
public class OperationController {
    @GetMapping("/calculate")
    public String showCalculatorPage() {
        return "calculator";
    }

    @PostMapping("/calculate")
    public String calculate(@Valid OperationCreationDTO operationCreationDTO,
                            BindingResult bindingResult,
                            Model model){
        if (bindingResult.hasErrors()) {
            setValidationErrors(bindingResult, model);
            model.addAttribute("newOperation", operationCreationDTO);
            return "calculator";
        }


        return "calculator";
    }

    private void setValidationErrors(BindingResult bindingResult, Model model) {
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            model.addAttribute(fieldError.getField(), fieldError.getDefaultMessage());
        }
    }
}
