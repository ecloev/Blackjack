import java.util.ArrayList;
import java.util.Scanner;

/**
 * Blackjack (Text-based)
 *
 * Blackjack game with working wagers and rounds
 *
 * @author Ethan Loev and Ryan Slattery
 * @version 10/02/2020
 *
 */

public class Main {
    static int money = 50; // Player's money
    static int wager; // Wager (updates)
    static int playerTotal; // Player's hand total
    static int dealerTotal; // Dealer's hand total
    static ArrayList<Card> playerHand = new ArrayList<>();
    static ArrayList<Card> dealerHand = new ArrayList<>();
    static String hitOrStay = "";
    static boolean isRoundOver;
    static boolean playerHasAce;
    static boolean dealerHasAce;
    
    

    public static void main(String[] args) throws InterruptedException { // Execution begins
        Scanner scanner = new Scanner(System.in); // Instantiate scanner object
        System.out.print("Welcome to Blackjack! Enter your name: ");
        String playerName = scanner.nextLine();
        Game game = new Game(playerName);
        System.out.printf("%s, loading your game.......\n\n", game.getPlayerName()); // Sets up game
        game.deck = Game.shuffle(game.deck);
        Thread.sleep(3000);

        do {
            isRoundOver = false; // Reset isRoundOver
            playerTotal = 0; // Reset totals
            dealerTotal = 0;
            playerHand.clear(); // Clears hands
            dealerHand.clear();
            System.out.printf("You currently have $%d.\n", money);
            System.out.print("Enter a wager:\n");

            wager = scanner.nextInt();
            scanner.nextLine();

            System.out.printf("You have wagered $%d.\n", wager);
            System.out.print("Dealing cards...\n\n");

            Card playerCard1 = game.drawCard();
            Card playerCard2 = game.drawCard();
            Card dealerCard1 = game.drawCard();
            Card dealerCard2 = game.drawCard(); // This is the dealer's hidden card

            playerHand.add(playerCard1);
            playerHand.add(playerCard2); // Populating player's hand

            dealerHand.add(dealerCard1); // Populating dealer's hand
            dealerHand.add(dealerCard2);


            if (playerCard1.getValue().equals("A") || playerCard2.getValue().equals("A")){
                playerHasAce = true;
            }

            if (dealerCard1.getValue().equals("A") || dealerCard2.getValue().equals("A")){
                dealerHasAce = true;
            }


            for (Card card : playerHand) {
                playerTotal += card.value; // Calculates player total
            }

            for (Card card : dealerHand) {
                dealerTotal += card.value; // Calculates dealer total
            }

            System.out.print("You have: " + playerCard1.getValue() + playerCard1.getSuit() + " and "
                    + playerCard2.getValue() + playerCard2.getSuit() + "\n");
            System.out.printf("Your total is: %d\n\n" , playerTotal); // Prints player info


            System.out.println("The dealer shows: " + dealerCard1.getValue() + dealerCard1.getSuit()); // Prints dealer show-card

            if (playerTotal == 21) { // Checks for initial blackjack
                money += wager * 1.5;
                System.out.println("Blackjack! You win!");
                continue;
            }

            while (playerTotal < 21) { // Sets up iteration to complete rounds

                if (isRoundOver) {
                    break; // Break if round is over already
                }

                System.out.println("Do you want to hit or stay?");
                hitOrStay = scanner.nextLine();
                hitOrStay = hitOrStay.toLowerCase();

                // Dealer's actions
                // Ending scenarios
                switch (hitOrStay) {
                    case "stay" -> {
                        System.out.printf("You have chosen to stay with a hand total of: %d\n", playerTotal);
                        System.out.println("The dealer flips over: " + dealerCard2.getValue() + dealerCard2.getSuit());
                        System.out.printf("The dealer's total is: %d\n", dealerTotal);
                        Thread.sleep(1500);
                        while (dealerTotal < 17) {
                            System.out.println("Dealer must hit.\n");
                            Thread.sleep(1500);
                            Card newCard = game.drawCard();

                            if (newCard.getValue().equals("A")){
                                dealerHasAce = true;
                            }

                            System.out.printf("The dealer is dealt: %s%s\n", newCard.getValue(), newCard.getSuit());
                            Thread.sleep(1500);
                            dealerHand.add(newCard);
                            dealerTotal += newCard.value;


                            if (dealerTotal > 21 && dealerHasAce) {
                                dealerTotal -= 10; // Effectively turns Ace value from 11 to 1
                                dealerHasAce = false; // Stops from happening again (for same ace)
                            }


                        }
                        System.out.printf("The dealer now has a hand total of %d.\n", dealerTotal);
                        Thread.sleep(1500);

                        // Game outcomes
                        if (dealerTotal > 21) {
                            System.out.println("The dealer busted. You doubled your wager.");
                            Thread.sleep(1500);
                            money += wager;
                            isRoundOver = true;
                        }
                        if (dealerTotal < playerTotal) {
                            System.out.println("You win! You doubled your wager.");
                            Thread.sleep(1500);
                            money += wager;
                            isRoundOver = true;
                        }
                        if (dealerTotal == playerTotal) {
                            System.out.println("Push! You receive your wager back.");
                            Thread.sleep(1500);
                            Thread.sleep(1500);
                            isRoundOver = true;
                        }
                        if (dealerTotal > playerTotal && dealerTotal <= 21) {
                            System.out.println("You lose! The dealer takes your wager.");
                            Thread.sleep(1500);
                            money -= wager;
                            isRoundOver = true;
                        }
                    }
                    case "hit" -> {
                        Card newCard = game.drawCard();
                        System.out.printf("The player is dealt: %s%s\n", newCard.getValue(), newCard.getSuit());
                        Thread.sleep(1000);
                        playerHand.add(newCard);
                        playerTotal += newCard.value;

                        if (newCard.getValue().equals("A")){
                            playerHasAce = true;
                        }

                        if (playerTotal > 21 && playerHasAce) {
                            playerTotal -= 10; // Effectively turns Ace value from 11 to 1
                            playerHasAce = false; // Stops from happening again (for same ace)
                        }

                        if (playerTotal > 21) {
                            System.out.println("You bust! You lose your wager.");
                            Thread.sleep(1500);
                            money -= wager;
                            isRoundOver = true; // End round if player busts
                            break;
                        }
                        System.out.printf("Your hand's total is now %d.\n", playerTotal);
                    }
                }
            }

        } while(money > 0); // do-while
    }
}
