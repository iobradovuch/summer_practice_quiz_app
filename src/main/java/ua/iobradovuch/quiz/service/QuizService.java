package ua.iobradovuch.quiz.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import ua.iobradovuch.quiz.model.FlashCard;
import ua.iobradovuch.quiz.model.Quiz;
import ua.iobradovuch.quiz.repository.FlashCardRepository;
import ua.iobradovuch.quiz.repository.QuizRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    private final QuizRepository quizRepository;
    private final FlashCardRepository flashCardRepository;
    private final FlashCardService flashCardService;

    @PersistenceContext
    private EntityManager entityManager;

    public QuizService(QuizRepository quizRepository, FlashCardRepository flashCardRepository, FlashCardService flashCardService) {
        this.quizRepository = quizRepository;
        this.flashCardRepository = flashCardRepository;
        this.flashCardService = flashCardService;
    }

    public List<Quiz> getQuizzes() {
        return (List<Quiz>) quizRepository.findAll();
    }

    public void deleteQuizById(Integer quizID) {
        Quiz quiz = quizRepository.findById(quizID).orElseThrow();
        for (FlashCard flashCard : quiz.getFlashCards()) {
            flashCard.getQuizCollect().remove(quiz);
        }
        quiz.getFlashCards().clear();
        quizRepository.save(quiz);
        quizRepository.delete(quiz);
    }

    public boolean changeQuizTitle(Integer quizID, String newQuizTitle) {
        Optional<Quiz> optionalQuiz = quizRepository.findById(quizID);
        if (optionalQuiz.isPresent()) {
            Quiz quiz = optionalQuiz.get();
            quiz.setQuizTitle(newQuizTitle);
            quizRepository.save(quiz);
            return true;
        }
        return false;
    }

    public boolean createExampleQuiz() {
        Quiz quiz = new Quiz();
        quiz.setQuizTitle("Example");
        quizRepository.save(quiz);
        return true;
    }

}
