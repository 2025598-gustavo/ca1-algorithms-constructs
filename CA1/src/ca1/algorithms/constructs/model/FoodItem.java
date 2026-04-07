package ca1.algorithms.constructs.model;

import ca1.algorithms.constructs.repository.Food;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author Gustavo
 */
public class FoodItem implements Food {

    private String name;
    private double weight;
    private LocalDate bestBefore;
    private LocalDateTime timeStored;

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
        return "Name: " + name + " | Weight: " + weight + "g | Exp: " + bestBefore + " | Stored: " + timeStored;
    }
}