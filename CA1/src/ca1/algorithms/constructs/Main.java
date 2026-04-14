package ca1.algorithms.constructs;

import ca1.algorithms.constructs.enums.StorageTypeEnum;
import ca1.algorithms.constructs.repository.FoodStorage;
import ca1.algorithms.constructs.service.FoodService;
import ca1.algorithms.constructs.validation.Validation;
import java.util.Scanner;

/**
 *
 * @author Gustavo
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FoodStorage storage = null;

        while (true) {
            String storageName = "";
            String addLabel = "";
            String removeLabel = "";
            
            while (storage == null) {
                System.out.println("\n============================= "
                        + "\n  Restaurant Storage System "
                        + "\n=============================");

                System.out.println("\n========= Main Menu =========");

                System.out.println("Choose Storage Type:");
                System.out.println("1. Stack (LIFO)");
                System.out.println("2. Queue (FIFO)");
                System.out.println("3. Exit");
                System.out.print("Choice: ");

                // Validation input
                int choice = Validation.readValidInt(sc);
                
                switch (choice) {
                    case 1, 2 -> {
                        StorageTypeEnum type = StorageTypeEnum.fromChoice(choice);

                        storage = type.create();
                        storageName = type.getStorageName();
                        addLabel = type.getAddLabel();
                        removeLabel = type.getRemoveLabel();
                    }
                    case 3 -> {
                        System.out.println("Exiting program...");
                        sc.close();
                        return;
                    }
                    default ->
                        System.out.println("Invalid choice! Please try again.");
                }
            }

            boolean isBackToMenu = false;

            while (!isBackToMenu) {
                System.out.println("\n======= " + storageName + " =======");
                System.out.println("1. Add Food " + addLabel);
                System.out.println("2. Remove Food " + removeLabel);
                System.out.println("3. View top item (Peek)");
                System.out.println("4. Display all items");
                System.out.println("5. Show Storage Size");
                System.out.println("6. Exit");
                System.out.print("Choice: ");

                // Validation input
                int choice = Validation.readValidInt(sc);

                switch (choice) {
                case 1 -> FoodService.addFood(sc, storage);
                case 2 -> storage.removeFood();
                case 3 -> storage.peekFood();
                case 4 -> storage.displayFood();
                case 5 -> storage.size();
                case 6 -> {
                    System.out.println("Returning to main menu...");
                    storage = null; 
                    isBackToMenu = true;
                }
                default -> System.out.println("Invalid option!");
                }
            }
        }
    }
}