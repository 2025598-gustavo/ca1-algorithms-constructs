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