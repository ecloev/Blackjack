import java.util.ArrayList;

public class Card {
    int value;
    String valueString;
    String suit;

    public Card (int value, String suit) {
        this.value = value;
        this.suit = suit;
    }

    public Card (String valueString, String suit) {
        this.valueString = valueString;
        this.suit = suit;
    }
}
