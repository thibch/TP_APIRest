package fr.ul.tp_apirest.web.controller;

import fr.ul.tp_apirest.dao.ICardDAO;
import fr.ul.tp_apirest.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CardController {

    final ICardDAO dao;

    public CardController(@Autowired ICardDAO dao) {
        this.dao = dao;
    }

    @GetMapping("/cards")
    public List<Card> getCards() {
        return dao.findAll();
    }

    @GetMapping("/card/{id}")
    public Card getCards(@PathVariable String id) {
        return dao.findById(id).orElse(null);
    }

    @PostMapping(value = "/card", consumes = MediaType.ALL_VALUE)
    public Card addCard(@RequestBody Card card) {
        return dao.save(card);
    }

    @PutMapping(value = "/card/{id}", consumes = MediaType.ALL_VALUE)
    public Card updateCard(@PathVariable String id, @RequestBody Card card) {
        return dao.updateCard(id, card);
    }

    @DeleteMapping("/card/{id}")
    public void deleteCard(@PathVariable String id) {
        dao.deleteById(id);
    }
}
