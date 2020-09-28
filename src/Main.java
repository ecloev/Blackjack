import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    ArrayList<Card> possibleCards = new ArrayList<Card>();
    ArrayList<Card> deck = new ArrayList<Card>();
    static int money = 50;
    static int wager;
    
    static int playerTotal;
    static int dealerTotal;
    
    

    public static void main(String[] args) throws InterruptedException { // Execution begins
        Scanner scanner = new Scanner(System.in); // Instantiate scanner object
        System.out.print("Welcome to Blackjack! Enter your name: ");
        String playerName = scanner.nextLine();
        Game game = new Game(playerName);
        System.out.printf("%s, loading your game.......\n", game.getPlayerName());
        game.deck = Game.shuffle(game.deck);
        Thread.sleep(3000);

        System.out.printf("You currently have $%d.\n", money);
        System.out.printf("Enter a wager:\n");
        wager = scanner.nextInt();
        scanner.nextLine();

        System.out.printf("You have wagered $%d\n", wager);
        System.out.printf("Dealing cards...\n\n");
        Thread.sleep(2000);

        Card playerCard1 = game.drawCard();
        Card playerCard2 = game.drawCard();
        Card dealerCard1 = game.drawCard();
        Card dealerCard2 = game.drawCard(); // This is the dealer's hidden card

        // System.out.println("Cards left in deck: "+game.deck.size()); // For testing purposes

        playerTotal = playerCard1.value + playerCard2.value; // Adds the value Integers of the player cards

        // Runs the get.Value and get.Suit methods. Both return strings
        System.out.printf("You have: " + playerCard1.getValue() + playerCard1.getSuit()+" and "
                + playerCard2.getValue() + playerCard2.getSuit()+ "\n");
        System.out.printf("Your total is: %d\n\n" , playerTotal);


        System.out.println("The dealer shows: " + dealerCard1.getValue() +dealerCard2.getSuit());








    }
}
