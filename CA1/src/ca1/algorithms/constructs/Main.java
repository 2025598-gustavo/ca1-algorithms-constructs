package ca1.algorithms.constructs;

import ca1.algorithms.constructs.enums.StorageTypeEnum;
import ca1.algorithms.constructs.repository.FoodStorage;
import ca1.algorithms.constructs.service.FoodService;
import ca1.algorithms.constructs.validation.Validation;
import java.util.Scanner;

/**
 * Main class that controls the entire application flow.
 * It handles user interaction, menu navigation, and delegates operations
 * to the appropriate services and data structures.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FoodStorage storage = null; // Will hold either Stack or Queue implementation

        // Main application loop (runs until user chooses to exit)
        while (true) {

            // Dynamic labels depending on selected data structure
            String storageName = "";
            String addLabel = "";
            String removeLabel = "";

            // Main menu loop (forces user to select a storage type)
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

                // Read validated integer input
                int choice = Validation.readValidInt(sc);

                switch (choice) {
                    case 1, 2 -> {
                        // Convert user choice into enum representation
                        StorageTypeEnum type = StorageTypeEnum.fromChoice(choice);

                        // Create the selected data structure (Stack or Queue)
                        storage = type.create();

                        // Load dynamic labels based on selected type
                        storageName = type.getStorageName();
                        addLabel = type.getAddLabel();
                        removeLabel = type.getRemoveLabel();
                    }
                    case 3 -> {
                        System.out.println("Exiting program...");
                        sc.close();
                        return; // Terminates application
                    }
                    default ->
                        System.out.println("Invalid choice! Please try again.");
                }
            }

            boolean isBackToMenu = false; // Controls return to main menu

            // Storage operation menu loop
            while (!isBackToMenu) {
                System.out.println("\n======= " + storageName + " =======");
                System.out.println("1. Add Food " + addLabel);
                System.out.println("2. Remove Food " + removeLabel);
                System.out.println("3. View top item (Peek)");
                System.out.println("4. Display all items");
                System.out.println("5. Show Storage Size");
                System.out.println("6. Exit");
                System.out.print("Choice: ");

                // Read validated integer input
                int choice = Validation.readValidInt(sc);

                switch (choice) {
                    case 1 -> FoodService.addFood(sc, storage); // Delegate add logic
                    case 2 -> storage.removeFood(); // Remove element
                    case 3 -> storage.peekFood(); // View top/front element
                    case 4 -> storage.displayFood(); // Show all items
                    case 5 -> storage.size(); // Show number of items
                    case 6 -> {
                        System.out.println("Returning to main menu...");
                        storage = null; // Reset storage to force re-selection
                        isBackToMenu = true;
                    }
                    default -> System.out.println("Invalid option!");
                }
            }
        }
    }
}