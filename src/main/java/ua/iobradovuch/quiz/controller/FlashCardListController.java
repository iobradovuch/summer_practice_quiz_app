package ua.iobradovuch.quiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.iobradovuch.quiz.model.FlashCard;
import ua.iobradovuch.quiz.service.FlashCardService;

import java.util.List;

@Controller
public class FlashCardListController {

    private FlashCardService flashCardService;
    public FlashCardListController(FlashCardService flashCardService){
        this.flashCardService = flashCardService;
    }
    @GetMapping("/flashcardlist")
    public String getFlashCardList(Model model){
        List<FlashCard> flashCardList = flashCardService.getAllFlashCards();
        model.addAttribute("flashCardList", flashCardList);
        return "all_flash_cards";
    }
}
