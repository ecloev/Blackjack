import java.util.Scanner;

public class Main {

    public static void main(String[] args) { // Execution begins
        Scanner scanner = new Scanner(System.in); // Instantiate scanner object
        System.out.print("Welcome to Blackjack! Enter your name: ");
        String playerName = scanner.nextLine();
        var player1 = new Player(playerName); // Creates new player w/ specified name
        System.out.printf("Player 1: %s, loading your game...", playerName);
    }
}
