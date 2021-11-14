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

    /**
     * Get all cards
     * @return all cards
     */
    @GetMapping("/cards")
    public List<Card> getCards() {
        return dao.findAll();
    }

    /**
     * Get the card with the id
     * @param id id of the card
     * @return card with the id
     */
    @GetMapping("/card/{id}")
    public Card getCards(@PathVariable String id) {
        return dao.findById(id).orElse(null);
    }

    /**
     * Create a new card
     * @param card the new card
     * @return the new card in db (could be changed for any reason)
     */
    @PostMapping(value = "/card", consumes = MediaType.ALL_VALUE)
    public Card addCard(@RequestBody Card card) {
        return dao.save(card);
    }

    /**
     * Update the card with the id associated
     * @param id id of the card you want to update
     * @param card the new fields (except for the id)
     * @return The new card
     */
    @PutMapping(value = "/card/{id}", consumes = MediaType.ALL_VALUE)
    public Card updateCard(@PathVariable String id, @RequestBody Card card) {
        return dao.updateCard(id, card);
    }

    /**
     * Delete the card with the id
     * @param id The id of the card you want to delete
     */
    @DeleteMapping("/card/{id}")
    public void deleteCard(@PathVariable String id) {
        dao.deleteById(id);
    }
}
