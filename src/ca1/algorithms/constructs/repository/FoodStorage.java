package ca1.algorithms.constructs.repository;

public interface FoodStorage {
    void addFood(Food food);
    void removeFood();
    void peekFood();
    void displayFood();
    boolean isEmpty();
    boolean isFull();
}
