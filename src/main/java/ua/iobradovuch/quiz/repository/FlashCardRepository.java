package ua.iobradovuch.quiz.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.iobradovuch.quiz.model.FlashCard;

@Repository
public interface FlashCardRepository extends CrudRepository<FlashCard, Integer> {
    FlashCard findByCardID(Integer cardID);
}
