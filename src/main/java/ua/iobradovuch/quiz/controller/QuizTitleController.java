package ua.iobradovuch.quiz.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ua.iobradovuch.quiz.model.Quiz;
import ua.iobradovuch.quiz.repository.QuizRepository;
import ua.iobradovuch.quiz.service.QuizService;

@Controller
public class QuizTitleController {

    private QuizService quizService;
    private QuizRepository quizRepository;

    private Integer quizID;

    public QuizTitleController(QuizService quizService, QuizRepository quizRepository) {
        this.quizService = quizService;
        this.quizRepository = quizRepository;
    }

    @GetMapping("/editquiztitle")
    public String showQuizTitle(Model model, @RequestParam(value="quizid", required = false) Integer quizID, RedirectAttributes redirectAttributes){
        if(quizID == null) {
            return "redirect:/error";
        }
        this.quizID = quizID;
        Quiz quiz = quizRepository.findById(quizID).orElse(null);
        model.addAttribute("quiz", quiz);
        return "edit_quiz_title";
    }

    @PostMapping("/editquiztitle")
    public String changeQuizTitle(Model model, @RequestParam("quizTitle") String quizTitle, RedirectAttributes redirectAttributes) {
        boolean success = false;
        success = quizService.changeQuizTitle(quizID, quizTitle);
        String operationString = "edited";
        String entityString = "quiz title";
        if(success) {
            redirectAttributes.addFlashAttribute("operation",operationString);
            redirectAttributes.addFlashAttribute("entitytype",entityString);
            return "redirect:/successpage";
        } else {
            return "error";
        }
    }
}