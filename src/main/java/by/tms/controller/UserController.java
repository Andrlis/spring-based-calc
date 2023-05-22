package by.tms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Andrei Lisouski (Andrlis) - 22/05/2023 - 21:54
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "registration";
    }
}
