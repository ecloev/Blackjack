import java.util.ArrayList;

public class Card {
    int value;
    String valueString;
    String suit;
    int stringOrInt; // Tracks whether a card's value is an Integer or String

    public Card (int value, String suit) {
        this.value = value;
        this.suit = suit;
        this.stringOrInt = 0;
    }

    public Card (String valueString, String suit) {
        this.valueString = valueString;
        this.suit = suit;
        this.stringOrInt = 1;
    }

    public String getSuit () {
        return this.suit;
    }

    public String getValue () {
        if(stringOrInt == 1) {
            return this.valueString;
        } else {
            return Integer.toString(this.value);
        }
    }



}
