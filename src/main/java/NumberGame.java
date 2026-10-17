
import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        int roundsWon = 0;
        int round = 1;
        String playAgain;

        System.out.println("=================================");
        System.out.println("       WELCOME TO NUMBER GAME");
        System.out.println("=================================");

        do {
            int number = random.nextInt(100) + 1;
            int maxAttempts = 7;
            int attempts = 0;
            boolean guessed = false;

            System.out.println("\nRound " + round);
            System.out.println("Guess a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {

                System.out.print("Enter your guess: ");

                if (!sc.hasNextInt()) {
                    System.out.println("Please enter a valid integer.");
                    sc.next();
                    continue;
                }

                int guess = sc.nextInt();

                if (guess < 1 || guess > 100) {
                    System.out.println("Enter a number between 1 and 100.");
                    continue;
                }

                attempts++;

                if (guess == number) {
                    System.out.println("Correct! You guessed the number.");
                    System.out.println("Attempts used: " + attempts);

                    int points = (maxAttempts - attempts + 1) * 10;
                    totalScore += points;
                    roundsWon++;

                    System.out.println("Round score: " + points);
                    guessed = true;
                    break;

                } else if (guess < number) {
                    System.out.println("Too low! Try a higher number.");

                } else {
                    System.out.println("Too high! Try a lower number.");
                }

                System.out.println("Attempts remaining: "
                        + (maxAttempts - attempts));
            }

            if (!guessed) {
                System.out.println("Game over! The number was " + number);
            }

            System.out.println("\nRounds won: " + roundsWon);
            System.out.println("Total score: " + totalScore);

            System.out.print("\nDo you want to play another round? (yes/no): ");
            playAgain = sc.next().trim().toLowerCase();
            round++;

        } while (playAgain.equals("yes") || playAgain.equals("y"));

        System.out.println("\n========== FINAL RESULTS ==========");
        System.out.println("Total rounds played: " + (round - 1));
        System.out.println("Rounds won: " + roundsWon);
        System.out.println("Final score: " + totalScore);
        System.out.println("Thanks for playing!");

        sc.close();
    }
}
