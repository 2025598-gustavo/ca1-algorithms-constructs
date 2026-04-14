/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca1.algorithms.constructs.service;

import ca1.algorithms.constructs.model.FoodItem;
import ca1.algorithms.constructs.repository.FoodStorage;
import ca1.algorithms.constructs.repository.Food;
import ca1.algorithms.constructs.validation.Validation;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author Gustavo
 */
public class FoodService {
    
    public static void addFood(Scanner sc, FoodStorage storage) {
        System.out.println("\n---------- Add Food ---------");

        System.out.print("Food name: ");
        String name = sc.nextLine();

        System.out.print("Weight (g): ");
        double weight = Validation.readValidDouble(sc);

        LocalDate date = Validation.readValidDate(sc);

        Food food = new FoodItem(name, weight, date);
        storage.addFood(food);
    }
}