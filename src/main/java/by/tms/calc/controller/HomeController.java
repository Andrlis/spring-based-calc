package by.tms.calc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String showHomePage() {
        return "home";
    }
}
