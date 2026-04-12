package ca1.algorithms.constructs;

import ca1.algorithms.constructs.model.FoodItem;
import ca1.algorithms.constructs.model.Queue;
import ca1.algorithms.constructs.model.Stack;
import ca1.algorithms.constructs.repository.Food;
import ca1.algorithms.constructs.repository.FoodStorage;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author Gustavo
 */
public class Main {

public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FoodStorage storage = null;

        while (storage == null) {
            System.out.println("Choose Storage Type:");
            System.out.println("1. Queue (FIFO)");
            System.out.println("2. Stack (LIFO)");
            System.out.println("3. Exit");
            System.out.print("Choice: ");

            // Validation input
            int choice = validationInput(sc);

            switch (choice) {
                case 1 -> storage = new Queue(8);
                case 2 -> storage = new Stack(8);
                case 3 -> {
                    System.out.println("Exiting program...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Add Food");
            System.out.println("2. Remove Food");
            System.out.println("3. View top item (Peek)");
            System.out.println("4. Display all items");
            System.out.println("5. Show Storage Size");
            System.out.println("6. Exit");
            System.out.print("Choice: ");

            // Validation input
            int choice = validationInput(sc);

            switch (choice) {
                case 1 -> addFood(sc, storage);
                case 2 -> storage.removeFood();
                case 3 -> storage.peekFood();
                case 4 -> storage.displayFood();
                case 5 -> storage.size();
                case 6 -> {
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid option!");
            }
        }
    }

    private static void addFood(Scanner sc, FoodStorage storage) {
        System.out.print("Food name: ");
        String name = sc.nextLine();
        System.out.print("Weight (g): ");

        if (!sc.hasNextDouble()) {
            System.out.println("Invalid weight! Please enter a number.");
            sc.nextLine();
            return;
        }

        double weight = sc.nextDouble();
        sc.nextLine();
        System.out.print("Best-before (YYYY-MM-DD): ");
        String dateStr = sc.nextLine();

        try {
            LocalDate date = LocalDate.parse(dateStr);

            // validation 2 weeks
            if (date.isAfter(LocalDate.now().plusDays(14))) {
                System.out.println("Error: max 2 weeks allowed!");
                return;
            }

            Food food = new FoodItem(name, weight, date);
            storage.addFood(food);

        } catch (Exception e) {
            System.out.println("Invalid date format!");
        }
    }
    
    public static int validationInput(Scanner sc){
        while(true) {
            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                sc.nextLine();
                continue;
             }

            int choice = sc.nextInt();
            sc.nextLine();
            return choice;
        }
    }
}