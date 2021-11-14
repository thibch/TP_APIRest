package fr.ul.tp_apirest.dao;

import fr.ul.tp_apirest.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * This repository is strange
 * I had to ""implements"" all functions from MongoRepository
 * I'm not sure why so don't try to focus on the ones where the implementation is empty or bad
 * If it is empty I'm not using it
 */
@Repository
public class CardDAO implements ICardDAO {

    private final MongoTemplate mongoTemplate;

    public CardDAO(@Autowired MongoTemplate mongoTemplate) {
        System.out.println("Card DAO constructor");
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public <S extends Card> S save(S entity) {
        return this.mongoTemplate.save(entity);
    }

    @Override
    public <S extends Card> List<S> saveAll(Iterable<S> entities) {
        for(Card entity : entities) {
            this.mongoTemplate.save(entity);
        }
        return null;
    }

    @Override
    public List<Card> findAll() {
        return mongoTemplate.findAll(Card.class);
    }


    @Override
    public Optional<Card> findById(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        Card card = mongoTemplate.findOne(query, Card.class);
        return Optional.ofNullable(card);
    }

    @Override
    public boolean existsById(String s) {
        System.out.println(findById(s));
        return findById(s).isPresent();
    }

    @Override
    public void deleteById(String id) {
        Optional<Card> opt = this.findById(id);
        opt.ifPresent(this.mongoTemplate::remove);
    }

    @Override
    public Card updateCard(String id, Card card2) {
        if (this.existsById(id)) {
            card2.setId(id);
            this.mongoTemplate.save(card2);
            return this.findById(id).orElse(null);
        }
        return null;
    }

    @Override
    public void deleteAll() {
        // Because this.mongoTemplate.remove(Card.class); does not work
        this.mongoTemplate.remove(new Query(), Card.class);
    }

    @Override
    public Iterable<Card> findAllById(Iterable<String> strings) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public List<Card> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Card> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Card> S insert(S entity) {
        return null;
    }

    @Override
    public <S extends Card> List<S> insert(Iterable<S> entities) {
        return null;
    }

    @Override
    public <S extends Card> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Card> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Card> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Card> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Card> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Card> boolean exists(Example<S> example) {
        return false;
    }
    @Override
    public void delete(Card entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {

    }

    @Override
    public void deleteAll(Iterable<? extends Card> entities) {

    }

}
