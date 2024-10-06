/*
 * This is a train program
 * TRAIN is a program which uses the computer to generate problems
 * with random initial conditions to teach about the time-speed-
 * distance relationship (distance = rate x time). You then input
 * your answer and the computer verifies your response.
 *
 * @author  Justin Lavoie
 * @version 1.0
 * @since   2024-10-06
 */

import java.util.Scanner;
import java.util.Random;

/**
 * The TimeSpeedDistanceExercise class implements a program to generate
 * time-speed-distance problems for educational purposes.
 */
public final class TimeSpeedDistanceExercise {

    // Private constructor to prevent instantiation
    private TimeSpeedDistanceExercise() {
      throw new IllegalStateException("Cannot be instantiated");
    }

    /**
     * The main method to execute the exercise program.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String anotherProblem;

        do {
            System.out.println("TIME - SPEED - DISTANCE EXERCISE");

            // Generate random values
            int carSpeed = random.nextInt(25) + 40; // Speed of car
            int hourDifference = random.nextInt(15) + 5; // Difference in hours
            int trainSpeed = random.nextInt(19) + 20; // Speed of train

            // Display the problem
            System.out.printf("A CAR TRAVELING %d MPH CAN MAKE A CERTAIN%n",
                carSpeed);
            System.out.printf("TRIP IN %d HOURS LESS THAN A TRAIN%n",
                hourDifference);
            System.out.printf("TRAVELING AT %d MPH.%n", trainSpeed);

            double userAnswer = 0;
            boolean validInput = false;

            // Loop until valid input is received
            while (!validInput) {
                System.out.print("HOW LONG DOES THE TRIP TAKE BY CAR: ");
                try {
                    userAnswer = scanner.nextDouble();
                    validInput = true; // Set validInput to true if input valid
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next(); // Clear the invalid input
                }
            }

            // Calculate the correct answer
            double correctAnswer = (double) hourDifference * trainSpeed
                / (carSpeed - trainSpeed);
            int errorPercentage = (int) Math.round(Math.abs((correctAnswer
                - userAnswer) * 100 / userAnswer));

            // Check the answer and provide feedback
            if (errorPercentage > 5) {
                System.out.printf("SORRY. YOU WERE OFF BY %d PERCENT.%n",
                    errorPercentage);
            } else {
                System.out.printf("GOOD! ANSWER WITHIN %d PERCENT.%n",
                    errorPercentage);
            }
            System.out.printf("CORRECT ANSWER IS %.2f HOURS.%n",
                correctAnswer);
            System.out.println();

            // Ask if the user wants another problem
            System.out.print("ANOTHER PROBLEM (YES OR NO): ");
            anotherProblem = scanner.next();
            System.out.println();

        } while (anotherProblem.equalsIgnoreCase("YES"));

        scanner.close();
        System.out.println("\nDone."); // Indicate program completion
    }
}
