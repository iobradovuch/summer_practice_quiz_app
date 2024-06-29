package ua.iobradovuch.quiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ua.iobradovuch.quiz.model.Quiz;
import ua.iobradovuch.quiz.repository.FlashCardRepository;
import ua.iobradovuch.quiz.repository.QuizRepository;
import ua.iobradovuch.quiz.service.QuizService;

@Controller
public class QuizDeletionController {

    private QuizRepository quizRepository;
    private FlashCardRepository flashCardRepository;
    private QuizService quizService;
    private Integer quizID;

    public QuizDeletionController(QuizRepository quizRepository, FlashCardRepository flashCardRepository, QuizService quizService) {
        this.quizRepository = quizRepository;
        this.flashCardRepository = flashCardRepository;
        this.quizService = quizService;
    }

    @GetMapping("/deletequiz")
    public String quizEditPage(Model model, @RequestParam("quizid") Integer quizID) {
        Quiz quiz = quizRepository.findById(quizID).orElse(null);
        if(quizID == null) {
            return "error";
        }

        this.quizID = quizID;
        model.addAttribute("quiz", quiz);
        return "delete_quiz";
    }

    @PostMapping("/deletequiz")
    public String getQuizEdits(Model model, Quiz quiz, RedirectAttributes redirectAttributes) {
        String operationString = "deleted";
        String entityString = "quiz";
            try{
                quizService.deleteQuizById(quizID);
                operationString = "deleted";
            }
            catch (Exception e)
            {
                System.out.println("Error deleting entity!");
                System.out.println(e);
                return "redirect:/error";
            }
        redirectAttributes.addFlashAttribute("operation", operationString);
        redirectAttributes.addFlashAttribute("entitytype", entityString);
        return "redirect:/successpage";
    }
}
