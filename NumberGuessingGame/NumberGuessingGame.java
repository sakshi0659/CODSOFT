package NumberGuessingGame;
import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame{
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 7;
        int score = 0;
        int round = 1;
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attemptsLeft = maxAttempts;
            boolean guessedCorrectly = false;

            System.out.println("\nRound " + round + ":");
            System.out.println("Guess the number between " + lowerBound + " and " + upperBound + ".");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");
                int guess;

                if (scanner.hasNextInt()) {
                    guess = scanner.nextInt();
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next();
                    continue;
                }

                if (guess < lowerBound || guess > upperBound) {
                    System.out.println("Please enter a number between " + lowerBound + " and " + upperBound + ".");
                    continue;
                }

                attemptsLeft--;

                if (guess == numberToGuess) {
                    System.out.println("Correct! You guessed the number in " + (maxAttempts - attemptsLeft) + " attempts.");
                    score++;
                    guessedCorrectly = true;
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("Too low.");
                } else {
                    System.out.println("Too high.");
                }

                System.out.println("Attempts remaining: " + attemptsLeft);
            }

            if (!guessedCorrectly) {
                System.out.println("You're out of attempts! The number was: " + numberToGuess);
            }

            System.out.println("Current Score: " + score + " round(s) won.");

            System.out.print("Do you want to play another round? (yes/no): ");
            scanner.nextLine(); // consume leftover newline
            String response = scanner.nextLine().trim().toLowerCase();
            if (!response.equals("yes") && !response.equals("y")) {
                playAgain = false;
            } else {
                round++;
            }
        }

        System.out.println("\nThanks for playing! Final score: " + score + " round(s) won.");
        scanner.close();
    }
}
