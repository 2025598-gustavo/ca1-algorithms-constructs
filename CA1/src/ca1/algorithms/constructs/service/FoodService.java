package ca1.algorithms.constructs.service;

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

        System.out.print("Food name: ");
        String name = sc.nextLine();

        // Read validated inputs
        double weight = Validation.readValidDouble(sc);
        LocalDate date = Validation.readValidDate(sc);

        // Create Food object
        Food food = new FoodItem(name, weight, date);

        // Add to storage
        storage.addFood(food);
    }
}