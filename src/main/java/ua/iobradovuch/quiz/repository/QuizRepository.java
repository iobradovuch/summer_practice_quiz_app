package ua.iobradovuch.quiz.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.iobradovuch.quiz.model.Quiz;

@Repository
public interface QuizRepository extends CrudRepository<Quiz, Integer> {
    Quiz findByQuizID(Integer quizID);
}
