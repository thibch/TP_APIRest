package fr.ul.tp_apirest.dao;

import fr.ul.tp_apirest.model.Card;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface ICardDAO extends MongoRepository<Card, String> {
    List<Card> findAll();

    Optional<Card> findById(String id);

    void deleteById(String id);

    Card updateCard(String id, Card card);
}
