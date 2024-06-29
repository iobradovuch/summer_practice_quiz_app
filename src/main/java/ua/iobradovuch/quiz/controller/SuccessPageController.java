package ua.iobradovuch.quiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SuccessPageController {

    @GetMapping("/successpage")
    public String showSuccessPage(Model model, @RequestParam(name = "operation", required = false) String operation, @RequestParam(name = "entitytype", required = false) String entityType) {
        if(entityType == null) {
            entityType = "object";
        }
        if(operation == null) {
            operation = "changed";
        }
        return "success_page";
    }

}
