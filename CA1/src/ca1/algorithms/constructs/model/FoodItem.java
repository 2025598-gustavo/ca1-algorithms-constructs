package ca1.algorithms.constructs.model;

import ca1.algorithms.constructs.repository.Food;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Gustavo
 */
public class FoodItem implements Food {

    private final String name;
    private final double weight;
    private final LocalDate bestBefore;
    private final LocalDateTime timeStored;

    public FoodItem(String name, double weight, LocalDate bestBefore) {
        this.name = name;
        this.weight = weight;
        this.bestBefore = bestBefore;
        this.timeStored = LocalDateTime.now();
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

    @Override
    public String toString() {
        DateTimeFormatter dateFormatter = 
                DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter dateTimeFormatter = 
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        return "Name: " + name +
               " | Weight: " + weight + "g" +
               " | Exp: " + bestBefore.format(dateFormatter) +
               " | Stored: " + timeStored.format(dateTimeFormatter);
    }
}