package ua.iobradovuch.quiz.service;

import org.springframework.stereotype.Service;
import ua.iobradovuch.quiz.model.FlashCard;
import ua.iobradovuch.quiz.model.Quiz;
import ua.iobradovuch.quiz.repository.FlashCardRepository;
import ua.iobradovuch.quiz.repository.QuizRepository;

import java.util.List;

@Service
public class FlashCardService {
    private final FlashCardRepository flashCardRepository;
    private final QuizRepository quizRepository;

    public FlashCardService(FlashCardRepository flashCardRepository, QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
        this.flashCardRepository = flashCardRepository;
    }

    public List<FlashCard> getAllFlashCards() {

        return (List<FlashCard>) flashCardRepository.findAll();
    }

    public void deleteFlashCardById(Integer cardID) {
        FlashCard flashcard = flashCardRepository.findById(cardID).orElseThrow();
        for (Quiz quiz : flashcard.getQuizCollect()) {
            quiz.getFlashCards().remove(flashcard);
        }

        flashcard.getQuizCollect().clear();
        flashCardRepository.save(flashcard);
        flashCardRepository.delete(flashcard);
    }
}