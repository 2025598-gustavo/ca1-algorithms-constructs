package ca1.algorithms.constructs;

import ca1.algorithms.constructs.model.FoodItem;
import ca1.algorithms.constructs.model.Queue;
import ca1.algorithms.constructs.model.Stack;
import ca1.algorithms.constructs.repository.Food;
import ca1.algorithms.constructs.repository.FoodStorage;

import java.time.LocalDate;
import java.util.Scanner;

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
            int type = sc.nextInt();

            switch (type) {
                case 1:
                    storage = new Queue(8);
                    break;
                case 2:
                    storage = new Stack(8);
                    break;
                case 3:
                    System.out.println("Exiting program...");
                    sc.close();
                    return; // termina a main
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Add Food");
            System.out.println("2. Remove Food");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Food name: ");
                    String name = sc.nextLine();

                    System.out.print("Weight (g): ");
                    double weight = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Best-before (YYYY-MM-DD): ");
                    String dateStr = sc.nextLine();

                    try {
                        LocalDate date = LocalDate.parse(dateStr);

                        // validação 2 semanas
                        if (date.isAfter(LocalDate.now().plusDays(14))) {
                            System.out.println("Error: max 2 weeks allowed!");
                            break;
                        }

                        Food food = new FoodItem(name, weight, date);
                        storage.addFood(food);

                    } catch (Exception e) {
                        System.out.println("Invalid date format!");
                    }
                    break;

                case 2:
                    storage.removeFood();
                    break;

                case 3:
                    storage.peekFood();
                    break;

                case 4:
                    storage.displayFood();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}