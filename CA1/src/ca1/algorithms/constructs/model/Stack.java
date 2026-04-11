package ca1.algorithms.constructs.model;

import ca1.algorithms.constructs.repository.FoodStorage;
import ca1.algorithms.constructs.repository.Food;

/**
 *
 * @author Gustavo
 */
public class Stack implements FoodStorage {

    private final Food[] stack;
    private int top;
    private final int capacity;

    public Stack(int size) {
        stack = new Food[size];
        capacity = size;
        top = -1;
    }

    @Override
    public void addFood(Food food) {
        if (top == capacity - 1) {
            System.out.println("Storage is full!");
            return;
        }
        stack[++top] = food;
        System.out.println("Food added: " + food);
    }

    @Override
    public void removeFood() {
        if (top == -1) {
            System.out.println("Storage is empty!");
            return;
        }
        Food food = stack[top--];
        System.out.println("Food removed: " + food);
    }

    @Override
    public void peekFood() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.println("Top item: " + stack[top]);
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return top == capacity - 1;
    }

    @Override
    public void displayFood() {
        if (top == -1) {
            System.out.println("Stack is empty!");
            return;
        }
        System.out.print("\n--- Stack elements contents ---");
        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }
    
    @Override
    public void searchFood(String name) {
        if (isEmpty()) {
            System.out.println("Storage is empty!");
            return;
        }

        boolean found = false;

        for (int i = 0; i <= top; i++) {
            if (stack[i].getName().equalsIgnoreCase(name)) {
                System.out.println("Found: " + stack[i]);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Food not found.");
        }
    }

    @Override
    public void size() {
        if (isEmpty()) {
            System.out.println("Storage size: 0");
        } else {
            System.out.println("Storage size: " + (top + 1));
        }
    }
}