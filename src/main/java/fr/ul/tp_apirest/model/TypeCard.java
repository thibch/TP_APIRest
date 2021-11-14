package fr.ul.tp_apirest.model;

import org.springframework.stereotype.Component;

/**
 * This object is only used to experiment if objects inside object are possible and easy to use or not
 *     In fact the only ""hard"" part is when you want to send the data in the html's body
 */
@Component
public class TypeCard {

    private String type;

    public TypeCard() {
        this.type = "Inconnu";
    }

    public TypeCard(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return '\'' + type + '\'';
    }
}
