package ua.iobradovuch.quiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class GradePageController {

    @GetMapping("/gradepage")
    public String getGradePage(Model model, @ModelAttribute("quizGrade") Long quizGrade) {
        model.addAttribute(quizGrade);
        return "quiz_grade_page";
    }
}
