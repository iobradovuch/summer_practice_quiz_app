package ua.iobradovuch.quiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.iobradovuch.quiz.model.FlashCard;
import ua.iobradovuch.quiz.repository.FlashCardRepository;
import ua.iobradovuch.quiz.service.FlashCardService;

import java.util.List;
import java.util.Random;

@Controller
public class FlashCardPageController {

    private FlashCardRepository flashCardRepository;
    private FlashCardService flashCardService;
    Integer cardID;

    public FlashCardPageController(FlashCardRepository flashCardRepository, FlashCardService flashCardService)
    {
        this.flashCardRepository = flashCardRepository;
        this.flashCardService = flashCardService;
    }

    @GetMapping({"/flashcard"})
    public String displayFlashCard(Model model, @RequestParam(value = "cardid", required = false) Integer cardID, @RequestParam(value="randomcard", required = false) String randomCard)
    {
        if((randomCard != null) && (randomCard.equals("true"))) {
            List<FlashCard> cards = flashCardService.getAllFlashCards();
            Random randomNumber = new Random();
            Integer randomCardNumber = randomNumber.nextInt(cards.size()) + 0;
            cardID = cards.get(randomCardNumber).getCardID();
        }

        if(cardID == null) {
            cardID = 1;
        }

        this.cardID = cardID;

        FlashCard flashCard = flashCardRepository.findById(cardID).orElse(null);

        if(flashCard != null) {
            String question = flashCard.getQuestion();
            Integer answerNumber = flashCard.getAnswer();
            if(answerNumber == null) {
                answerNumber = 1;
            }
            List<String> answerList = flashCard.getAnswerList();
            String answer = answerList.get(answerNumber - 1);

            model.addAttribute("displayQuestion", question);
            model.addAttribute("answer", answer);
            model.addAttribute("answerList", answerList);
        }
        return "flash_card_page";
    }
}
