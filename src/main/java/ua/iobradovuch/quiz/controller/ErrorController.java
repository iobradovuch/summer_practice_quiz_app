package ua.iobradovuch.quiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ErrorController {

    @GetMapping("/customerror")
    public String customError(Model model, @RequestParam("errormessage") String errorMessage){
        model.addAttribute("errormessage", errorMessage);
        return "error_custom";
    }
}
