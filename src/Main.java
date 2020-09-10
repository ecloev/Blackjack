import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    ArrayList<Card> possibleCards = new ArrayList<Card>();
    ArrayList<Card> deck = new ArrayList<Card>();

    public static void main(String[] args) { // Execution begins
        Scanner scanner = new Scanner(System.in); // Instantiate scanner object
        System.out.print("Welcome to Blackjack! Enter your name: ");
        String playerName = scanner.nextLine();
        var player = new Player(playerName); // Creates new player w/ specified name
        System.out.printf("Player 1: %s, loading your game...\n\n", playerName);
        Thread.sleep(3000);
        

    }
}
