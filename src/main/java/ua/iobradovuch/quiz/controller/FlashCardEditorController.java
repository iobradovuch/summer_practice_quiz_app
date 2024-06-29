package ua.iobradovuch.quiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ua.iobradovuch.quiz.model.FlashCard;
import ua.iobradovuch.quiz.repository.FlashCardRepository;
import ua.iobradovuch.quiz.service.FlashCardService;

@Controller
public class FlashCardEditorController {

    private FlashCardRepository flashCardRepository;
    private FlashCardService flashCardService;
    private Integer cardID;

    public FlashCardEditorController(FlashCardRepository flashCardRepository, FlashCardService flashCardService) {
        this.flashCardRepository = flashCardRepository;
        this.flashCardService = flashCardService;
    }

    @GetMapping("/editflashcard")
    public String showFlashCardEditor(Model model, @RequestParam("cardid") Integer cardID) {
        this.cardID = cardID;
        FlashCard flashCard = flashCardRepository.findById(cardID).orElse(null);
        model.addAttribute("flashcard", flashCard);
        return "edit_flash_card";
    }

    @PostMapping("/editflashcard")
    public String editFlashCard(Model model, FlashCard flashCard, @RequestParam(name = "deletecard", required = false) boolean deleteCard, RedirectAttributes redirectAttributes) {
        String operationString = "edited";
        String entityString = "card";
        if(deleteCard) {
            try{
                flashCardService.deleteFlashCardById(cardID);
                operationString = "deleted";
            }
            catch (Exception e)
            {
                System.out.println("Error deleting entity!");
                System.out.println(e);
                return "redirect:/error";
            }
        }
        else {
            flashCard.setCardID(cardID);
            flashCardRepository.save(flashCard);
        }
        redirectAttributes.addFlashAttribute("operation",operationString);
        redirectAttributes.addFlashAttribute("entitytype",entityString);
        return "redirect:/successpage";
    }
}