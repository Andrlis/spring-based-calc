package by.tms.calc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
