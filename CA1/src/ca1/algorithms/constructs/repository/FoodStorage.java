package ca1.algorithms.constructs.repository;

/**
 * Interface representing storage behavior.
 * Implemented by Stack and Queue.
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