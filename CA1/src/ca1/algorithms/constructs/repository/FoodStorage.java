/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ca1.algorithms.constructs.repository;

/**
 *
 * @author Gustavo
 */
public interface FoodStorage {
    void addFood(Food food);
    void removeFood();
    void peekFood();
    void displayFood();
    void size();
    boolean isEmpty();
    boolean isFull();
}