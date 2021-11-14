package fr.ul.tp_apirest;

import fr.ul.tp_apirest.dao.CardDAO;
import fr.ul.tp_apirest.model.Card;
import fr.ul.tp_apirest.model.TypeCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import java.util.Arrays;

@SpringBootApplication
public class TpApiRestApplication implements CommandLineRunner {

    private final CardDAO repository;

    public TpApiRestApplication(@Autowired CardDAO repository) {
        this.repository = repository;
    }

    public static void main(String[] args) {
        SpringApplication.run(TpApiRestApplication.class, args);
    }

    /**
     * Clear all elements and insert the default ones
     */
    @Override
    public void run(String... args) {

        repository.deleteAll();

        // save some cards
        repository.save(new Card("0001", 3, "Jean Cristhobaldo", new TypeCard("LEGENDE")));
        repository.save(new Card("0002", 5, "Zerator", new TypeCard("STREAMER")));
        repository.save(new Card("0003", 1, "Le katana", new TypeCard("Arme")));
        repository.save(new Card("0004", 4, "Ordinateur portable", new TypeCard("Magique")));

        // fetch all
        System.out.println("Cards found with findAll():");
        System.out.println("-------------------------------");
        for (Card card : repository.findAll()) {
            System.out.println(card);
        }
        System.out.println();
    }
}
