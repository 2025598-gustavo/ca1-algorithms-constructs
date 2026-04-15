package ca1.algorithms.constructs.service;

import ca1.algorithms.constructs.enums.FoodTypeEnum;
import ca1.algorithms.constructs.model.FoodItem;
import ca1.algorithms.constructs.repository.FoodStorage;
import ca1.algorithms.constructs.repository.Food;
import ca1.algorithms.constructs.validation.Validation;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * Service layer responsible for business logic related to food.
 * Separates logic from the Main class.
 */
public class FoodService {
    
    /**
     * Handles the process of adding a food item.
     * Includes input collection and validation.
     * @param sc
     * @param storage
     */
    public static void addFood(Scanner sc, FoodStorage storage) {
        System.out.println("\n---------- Add Food ---------");
        FoodTypeEnum foodType;

        // Loop until valid food option is selected
        while (true) {
            System.out.println("Select Food Type:");
            System.out.println("1. Burger");
            System.out.println("2. Pizza");
            System.out.println("3. Fries");
            System.out.println("4. Sandwich");
            System.out.println("5. Hotdog");
            System.out.print("Choice: ");

            int choice = Validation.readValidInt(sc);

            try {
                foodType = FoodTypeEnum.fromChoice(choice);
                break; // valid input → exit loop
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid choice! Please try again.\n");
            }
        }
        
        // Read validated inputs
        double weight = Validation.readValidDouble(sc);
        LocalDate date = Validation.readValidDate(sc);

        // Create Food object
        Food food = new FoodItem(foodType.getDisplayName(), weight, date);

        // Add to storage
        storage.addFood(food);
    }
}