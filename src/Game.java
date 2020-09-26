import java.util.ArrayList;

public class Game {
    String playerName;
    ArrayList<Card> deck = new ArrayList<>();

    public Game(String playerName) {
        this.playerName = playerName;
        
        // Cards are organized Ace through King and by Suit
        
        // Spades

        Card card1 = new Card("A", "s");
        deck.add(card1);
        Card card2 = new Card(2, "s");
        deck.add(card2);
        Card card3 = new Card(3, "s");
        deck.add(card3);
        Card card4 = new Card(4, "s");
        deck.add(card4);
        Card card5 = new Card(5, "s");
        deck.add(card5);
        Card card6 = new Card(6, "s");
        deck.add(card6);
        Card card7 = new Card(7, "s");
        deck.add(card7);
        Card card8 = new Card(8, "s");
        deck.add(card8);
        Card card9 = new Card(9, "s");
        deck.add(card9);
        Card card10 = new Card(10, "s");
        deck.add(card10);
        Card card11 = new Card("J", "s");
        deck.add(card11);
        Card card12 = new Card("Q", "s");
        deck.add(card12);
        Card card13 = new Card("K", "s");
        deck.add(card13);

        // Clubs

        Card card14 = new Card("A", "c");
        deck.add(card14);
        Card card15 = new Card(2, "c");
        deck.add(card15);
        Card card16 = new Card(3, "c");
        deck.add(card16);
        Card card17 = new Card(4, "c");
        deck.add(card17);
        Card card18 = new Card(5, "c");
        deck.add(card18);
        Card card19 = new Card(6, "c");
        deck.add(card19);
        Card card20 = new Card(7, "c");
        deck.add(card20);
        Card card21 = new Card(8, "c");
        deck.add(card21);
        Card card22 = new Card(9, "c");
        deck.add(card22);
        Card card23 = new Card(10, "c");
        deck.add(card23);
        Card card24 = new Card("J", "c");
        deck.add(card24);
        Card card25 = new Card("Q", "c");
        deck.add(card25);
        Card card26 = new Card("K", "c");
        deck.add(card26);

        // Hearts

        Card card27 = new Card("A", "h");
        deck.add(card27);
        Card card28 = new Card(2, "h");
        deck.add(card28);
        Card card29 = new Card(3, "h");
        deck.add(card29);
        Card card30 = new Card(4, "h");
        deck.add(card30);
        Card card31 = new Card(5, "h");
        deck.add(card31);
        Card card32 = new Card(6, "h");
        deck.add(card32);
        Card card33 = new Card(7, "h");
        deck.add(card33);
        Card card34 = new Card(8, "h");
        deck.add(card34);
        Card card35 = new Card(9, "h");
        deck.add(card35);
        Card card36 = new Card(10, "h");
        deck.add(card36);
        Card card37 = new Card("J", "h");
        deck.add(card37);
        Card card38 = new Card("Q", "h");
        deck.add(card38);
        Card card39 = new Card("K", "h");
        deck.add(card39);
        
        // Diamonds

        Card card40 = new Card("A", "d");
        deck.add(card40);
        Card card41 = new Card(2, "d");
        deck.add(card41);
        Card card42 = new Card(3, "d");
        deck.add(card42);
        Card card43 = new Card(4, "d");
        deck.add(card43);
        Card card44 = new Card(5, "d");
        deck.add(card44);
        Card card45 = new Card(6, "d");
        deck.add(card45);
        Card card46 = new Card(7, "d");
        deck.add(card46);
        Card card47 = new Card(8, "d");
        deck.add(card47);
        Card card48 = new Card(9, "d");
        deck.add(card48);
        Card card49 = new Card(10, "d");
        deck.add(card49);
        Card card50 = new Card("J", "d");
        deck.add(card50);
        Card card51 = new Card("Q", "d");
        deck.add(card51);
        Card card52 = new Card("K", "d");
        deck.add(card52);

    }

    public String getPlayerName() {
        return playerName;
    }
}
