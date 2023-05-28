package by.tms.calc.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Andrei Lisouski (Andrlis) - 29/05/2023 - 1:02
 */

@ControllerAdvice
public class ExceptionController {

  @ExceptionHandler(Throwable.class)
  public String th(Throwable e, Model model) {
    model.addAttribute("message", e.getMessage());
    return "error";
  }
}
