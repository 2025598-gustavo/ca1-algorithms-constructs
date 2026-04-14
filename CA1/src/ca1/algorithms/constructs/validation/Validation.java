/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca1.algorithms.constructs.validation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author Gustavo
 */
public class Validation {
    
    public static int readValidInt(Scanner sc) {
        while (true) {
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
    
    public static double readValidDouble(Scanner sc) {
        while (true) {
            System.out.print("Weight (g): ");
            if (!sc.hasNextDouble()) {
                System.out.println("Invalid weight! Please enter a number.");
                sc.nextLine();
                continue;
            }

            double value = sc.nextDouble();
            sc.nextLine();
            return value;
        }
    }

    public static LocalDate readValidDate(Scanner sc) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        while (true) {
            System.out.print("Best-before (DD-MM-YYYY): ");
            String input = sc.nextLine();

            try {
                LocalDate date = LocalDate.parse(input, formatter);

                if (date.isAfter(LocalDate.now().plusDays(14))) {
                    System.out.println("Error: max 2 weeks allowed!");
                    continue;
                }

                return date;
            } catch (Exception e) {
                System.out.println("Invalid date format! Use DD-MM-YYYY.");
            }
        }
    } 
}