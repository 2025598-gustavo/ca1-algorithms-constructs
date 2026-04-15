package ca1.algorithms.constructs.validation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Utility class responsible for validating user input.
 * Prevents invalid data from entering the system.
 */
public class Validation {

    /**
     * Reads a valid integer from user input.
     * Keeps asking until a valid number is entered.
     * @param sc
     * @return 
     */
    public static int readValidInt(Scanner sc) {
        while (true) {
            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                sc.nextLine(); // Clear invalid input
                continue;
            }

            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline
            return choice;
        }
    }

    /**
     * Reads a valid double (weight).
     * @param sc
     * @return 
     */
    public static double readValidDouble(Scanner sc) {
        while (true) {
            System.out.print("Weight (g): ");
            if (!sc.hasNextDouble()) {
                System.out.println("Invalid weight! Please enter a number.");
                sc.nextLine();
                continue;
            }

            double value = sc.nextDouble();
            sc.nextLine();
            return value;
        }
    }

    /**
     * Reads and validates a date in DD-MM-YYYY format.
     * Also enforces the 2-week expiration rule.
     * @param sc
     * @return 
     */
    public static LocalDate readValidDate(Scanner sc) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        while (true) {
            System.out.print("Best-before (DD-MM-YYYY): ");
            String input = sc.nextLine();

            try {
                LocalDate date = LocalDate.parse(input, formatter);

                // Business rule: max 2 weeks ahead
                if (date.isAfter(LocalDate.now().plusDays(14))) {
                    System.out.println("Error: max 2 weeks allowed!");
                    continue;
                }

                return date;
            } catch (Exception e) {
                System.out.println("Invalid date format! Use DD-MM-YYYY.");
            }
        }
    }
}