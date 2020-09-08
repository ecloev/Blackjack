import java.util.Scanner;

public class Main {

    public static void main(String[] args) { //this is the main method
        Scanner scanner = new Scanner(System.in);
        System.out.print("Welcome to Blackjack! Enter your name: ");
        String playerName = scanner.nextLine();
        var player1 = new Player(playerName);
        System.out.printf("Player 1: %s, loading your game...", playerName);
    }
}
