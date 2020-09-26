import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    ArrayList<Card> possibleCards = new ArrayList<Card>();
    ArrayList<Card> deck = new ArrayList<Card>();
    static int money = 50;
    static int wager = 0;

    public static void main(String[] args) throws InterruptedException { // Execution begins
        Scanner scanner = new Scanner(System.in); // Instantiate scanner object
        System.out.print("Welcome to Blackjack! Enter your name: ");
        String playerName = scanner.nextLine();
        Game game = new Game(playerName);
        System.out.printf("%s, loading your game.......\n", game.getPlayerName());
        game.deck = Game.shuffle(game.deck);
        Thread.sleep(3000);

        System.out.printf("You currently have $%d.\n", money);
        System.out.printf("How much would you like to wager:\n");




    }
}
