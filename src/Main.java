import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    ArrayList<Card> possibleCards = new ArrayList<Card>();
    ArrayList<Card> deck = new ArrayList<Card>();
    static int money = 50;
    static int wager;
    static int playerTotal;
    static int dealerTotal;
    static ArrayList<Card> playerHand = new ArrayList<Card>();
    static ArrayList<Card> dealerHand = new ArrayList<Card>();
    static String hitOrStay = "";
    static boolean isRoundOver;
    
    

    public static void main(String[] args) throws InterruptedException { // Execution begins
        Scanner scanner = new Scanner(System.in); // Instantiate scanner object
        System.out.print("Welcome to Blackjack! Enter your name: ");
        String playerName = scanner.nextLine();
        Game game = new Game(playerName);
        System.out.printf("%s, loading your game.......\n\n", game.getPlayerName());
        game.deck = Game.shuffle(game.deck);
        Thread.sleep(3000);

        do {
            isRoundOver = false;
            playerTotal = 0;
            dealerTotal = 0;
            playerHand.clear();
            dealerHand.clear();
            System.out.printf("You currently have $%d.\n", money);
            System.out.printf("Enter a wager:\n");

            wager = scanner.nextInt();
            scanner.nextLine();

            System.out.printf("You have wagered $%d.\n", wager);
            System.out.printf("Dealing cards...\n\n");

            Card playerCard1 = game.drawCard();
            Card playerCard2 = game.drawCard();
            Card dealerCard1 = game.drawCard();
            Card dealerCard2 = game.drawCard(); // This is the dealer's hidden card

            playerHand.add(playerCard1);
            playerHand.add(playerCard2); // Populating player's hand

            dealerHand.add(dealerCard1); // Populating dealer's hand
            dealerHand.add(dealerCard2);

            // System.out.println("Cards left in deck: "+game.deck.size()); // For testing purposes

            for (Card card : playerHand) {
                playerTotal += card.value;
            }

            for (Card card : dealerHand) {
                dealerTotal += card.value;
            }

            System.out.printf("You have: " + playerCard1.getValue() + playerCard1.getSuit() + " and "
                    + playerCard2.getValue() + playerCard2.getSuit() + "\n");
            System.out.printf("Your total is: %d\n\n" , playerTotal);


            System.out.println("The dealer shows: " + dealerCard1.getValue() + dealerCard1.getSuit());

            if (playerTotal == 21) {
                money += wager * 1.5;
                System.out.println("Blackjack! You win!");
                continue;
            }

            while (playerTotal < 21) {

                if (isRoundOver) {
                    break;
                }

                System.out.println("Do you want to hit or stay?");
                hitOrStay = scanner.nextLine();
                hitOrStay = hitOrStay.toLowerCase();

                switch (hitOrStay) {
                    case "stay":
                        System.out.printf("You have chosen to stay with a hand total of: %d\n", playerTotal);
                        System.out.println("The dealer flips over: " + dealerCard2.getValue() + dealerCard2.getSuit());
                        System.out.printf("The dealer's total is: %d\n", dealerTotal);

                        // Dealer's actions
                        while (dealerTotal < 17) {
                            System.out.println("Dealer must hit.\n");
                            Card newCard = game.drawCard();
                            System.out.printf("The dealer is dealt: %s%s\n", newCard.getValue(), newCard.getSuit());
                            dealerTotal += newCard.value;
                        }
                        System.out.printf("The dealer now has a hand total of %d.\n", dealerTotal);

                        // Ending scenarios
                        if (dealerTotal > 21) {
                            System.out.println("The dealer busted. You doubled your wager.");
                            money += wager;
                            isRoundOver = true;
                        }

                        if (dealerTotal < playerTotal) {
                            System.out.println("You win! You doubled your wager.");
                            money += wager;
                            isRoundOver = true;
                        }

                        if (dealerTotal == playerTotal) {
                            System.out.println("Push! You receive your wager back.");
                            isRoundOver = true;
                        }

                        if (dealerTotal > playerTotal && dealerTotal <= 21) {
                            System.out.println("You lose! The dealer takes your wager.");
                            money -= wager;
                            isRoundOver = true;
                        }
                        break;

                    case "hit":
                        Card newCard = game.drawCard();
                        System.out.printf("The player is dealt: %s%s\n", newCard.getValue(), newCard.getSuit());
                        playerTotal += Integer.parseInt(newCard.getValue());

                        if (playerTotal > 21) {
                            System.out.println("You bust! You lose your wager.");
                            money -= wager;
                            isRoundOver = true;
                            break;
                        }

                        System.out.printf("Your hand's total is now %d.", playerTotal);
                        break;
                }
            }

        } while(money > 0); // do-while
    }
}
