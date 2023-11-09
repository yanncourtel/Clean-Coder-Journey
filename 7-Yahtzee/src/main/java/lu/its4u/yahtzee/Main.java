package lu.its4u.yahtzee;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dice = new int[5];

        // Main game loop
        for (int round = 1; round <= 13; round++) {
            System.out.println("Round " + round);
            rollDice(dice);
            displayDice(dice);

            // Allow the player to reroll the dice up to two times
            for (int reroll = 0; reroll < 2; reroll++) {
                System.out.print("Do you want to reroll? (y/n): ");
                String input = scanner.next();

                if (input.toLowerCase().equals("y")) {
                    System.out.print("Enter the indices of dice to reroll (space-separated): ");
                    rerollDice(dice, scanner);
                    displayDice(dice);
                } else {
                    break;
                }
            }

            // Calculate and display score for the round
            int score = calculateScore(dice);
            System.out.println("Score for round " + round + ": " + score);
        }

        // Game over
        System.out.println("Game Over. Your final score is: " + calculateTotalScore());
        scanner.close();
    }

    // Other methods (rollDice, displayDice, rerollDice, calculateScore, calculateTotalScore) go here...

    // You'll need to implement the details of these methods based on the Yahtzee game rules.
}
