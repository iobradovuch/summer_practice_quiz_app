package ua.iobradovuch.quiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.iobradovuch.quiz.model.Quiz;
import ua.iobradovuch.quiz.service.QuizService;

import java.util.List;

@Controller
public class QuizListController {

    private QuizService quizService;
    public QuizListController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/quizlist")
    public String showQuizList(Model model) {
        List<Quiz> quizList = quizService.getQuizzes();
        model.addAttribute("quizList", quizList);
        return "all_quizzes";
    }
}
