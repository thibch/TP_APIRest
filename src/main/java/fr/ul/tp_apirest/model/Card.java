package fr.ul.tp_apirest.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.stereotype.Component;

@Component
@Document(collection = "Card")
public class Card {

    @Id
    @MongoId
    private String id = "";
    private int niveau = 0; // 1 à 5 level
    private String nom = "";
    private TypeCard type = new TypeCard();

    // ignore errors :)
    public Card(String id, int niveau, String nom, TypeCard typeCard) {
        this.id = id;
        this.niveau = niveau;
        this.nom = nom;
        this.type = typeCard;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public TypeCard getType() {
        return type;
    }

    public void setType(TypeCard type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id='" + id + '\'' +
                ", niveau=" + niveau +
                ", nom='" + nom + '\'' +
                ", type=" + type +
                '}';
    }
}
