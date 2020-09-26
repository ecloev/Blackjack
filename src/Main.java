import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    ArrayList<Card> possibleCards = new ArrayList<Card>();
    ArrayList<Card> deck = new ArrayList<Card>();

    public static void main(String[] args) throws InterruptedException { // Execution begins
        Scanner scanner = new Scanner(System.in); // Instantiate scanner object
        System.out.print("Welcome to Blackjack! Enter your name: ");
        String playerName = scanner.nextLine();
        Game game = new Game(playerName);
        System.out.printf("%s, loading your game.......\n", game.getPlayerName());
        Thread.sleep(3000);

        System.out.println(game.deck);

        game.deck = Game.shuffle(game.deck);

        System.out.println(game.deck);

    }
}
