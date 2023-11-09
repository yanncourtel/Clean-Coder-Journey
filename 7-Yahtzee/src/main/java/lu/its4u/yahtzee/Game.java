package main.java.lu.its4u.yahtzee;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class YahtzeeGame {

    private static final int NUM_DICE = 5;
    private static final int NUM_ROUNDS = 13;

    private static int[] dice = new int[NUM_DICE];
    private static boolean[] keep = new boolean[NUM_DICE];

    private static int[] scoreCard = new int[NUM_ROUNDS];

    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
        System.out.println("Welcome to Yahtzee!");

        for (int round = 0; round < NUM_ROUNDS; round++) {
            System.out.println("Round " + (round + 1));
            playRound();
            displayScoreCard();
        }

        int totalScore = calculateTotalScore();
        System.out.println("Game over! Your total score is: " + totalScore);
        scanner.close();
    }

    private static void playRound() {
        rollDice();
        for (int reroll = 0; reroll < 2; reroll++) {
            displayDice();
            askForReroll();
            rollSelectedDice();
        }

        displayDice();
        int category = getValidCategory();
        int score = calculateScore(category);
        scoreCard[category - 1] = score;
    }

    private static void rollDice() {
        for (int i = 0; i < NUM_DICE; i++) {
            dice[i] = random.nextInt(6) + 1; // Rolling a six-sided die
        }
    }

    private static void displayDice() {
        System.out.println("Current dice: " + Arrays.toString(dice));
    }

    private static void askForReroll() {
        System.out.print("Do you want to reroll? (y/n): ");
        String input = scanner.next();

        if (input.equalsIgnoreCase("y")) {
            Arrays.fill(keep, false);
            System.out.print("Enter the indices of dice to reroll (space-separated): ");
            String[] indices = scanner.next().split(" ");
            for (String index : indices) {
                int i = Integer.parseInt(index) - 1;
                keep[i] = true;
            }
        }
    }

    private static void rollSelectedDice() {
        for (int i = 0; i < NUM_DICE; i++) {
            if (!keep[i]) {
                dice[i] = random.nextInt(6) + 1;
            }
        }
    }

    private static int getValidCategory() {
        int category;
        do {
            System.out.print("Choose a category (1-13): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
            category = scanner.nextInt();
        } while (category < 1 || category > 13 || scoreCard[category - 1] != 0);

        return category;
    }

    private static int calculateScore(int category) {
        // Implement scoring logic based on selected category
        // For simplicity, let's assume all categories are valid for now
        return Arrays.stream(dice).sum();
    }

    private static void displayScoreCard() {
        System.out.println("Score Card:");
        for (int i = 0; i < NUM_ROUNDS; i++) {
            System.out.println("Category " + (i + 1) + ": " + (scoreCard[i] == 0 ? "Not filled" : scoreCard[i]));
        }
        System.out.println();
    }

    private static int calculateTotalScore() {
        return Arrays.stream(scoreCard).sum();
    }
}