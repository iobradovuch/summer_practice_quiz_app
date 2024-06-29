package ua.iobradovuch.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ua.iobradovuch.quiz.model.Quiz;
import ua.iobradovuch.quiz.repository.QuizRepository;

@Controller
@RequestMapping("/")
public class QuizGenerationController {

    @Autowired
    private QuizRepository quizRepository;

    @GetMapping("/generatequiz")
    public String showQuizGenerator() {
        return "quiz_generator";
    }

    @PostMapping("/generatequiz")
    public String getQuizTitle(Quiz quiz, RedirectAttributes redirectAttributes){
        quizRepository.save(quiz);
        redirectAttributes.addFlashAttribute("quiz", quiz);
        return "redirect:/generatecard";
    }
}
