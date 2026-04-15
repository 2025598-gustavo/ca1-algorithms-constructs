package ca1.algorithms.constructs.model;

import ca1.algorithms.constructs.repository.Food;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Concrete implementation of Food interface.
 * Represents a single food item stored in the system.
 */
public class FoodItem implements Food {

    // Immutable attributes (cannot be changed after creation)
    private final String name;
    private final double weight;
    private final LocalDate bestBefore;
    private final LocalDateTime timeStored;

    public FoodItem(String name, double weight, LocalDate bestBefore) {
        this.name = name;
        this.weight = weight;
        this.bestBefore = bestBefore;
        this.timeStored = LocalDateTime.now(); // Automatically set when created
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public LocalDate getBestBefore() {
        return bestBefore;
    }

    @Override
    public LocalDateTime getTimeStored() {
        return timeStored;
    }

    /**
     * Returns a formatted string representation of the food item.
     * Uses custom date formatting for better readability.
     */
    @Override
    public String toString() {
        DateTimeFormatter dateFormatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter dateTimeFormatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        return "Name: " + name + " | Weight: " + weight + "g" +
               " | Exp: " + bestBefore.format(dateFormatter) +
               " | Stored: " + timeStored.format(dateTimeFormatter);
    }
}