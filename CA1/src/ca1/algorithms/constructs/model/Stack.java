package ca1.algorithms.constructs.model;

import ca1.algorithms.constructs.repository.FoodStorage;
import ca1.algorithms.constructs.repository.Food;

/**
 * Stack implementation using an array.
 * This follows the LIFO (Last In First Out) principle:
 * The last element added is the first to be removed.
 */
public class Stack implements FoodStorage {

    private final Food[] stack; // Array to store food items
    private int top;            // Points to the top element
    private final int capacity; // Maximum capacity

    /**
     * Constructor initializes stack with given size.
     */
    public Stack(int size) {
        stack = new Food[size];
        capacity = size;
        top = -1;
    }

    /**
     * Adds a food item to the top of the stack.
     * Time Complexity: O(1)
     * @param food
     */
    @Override
    public void addFood(Food food) {
        if (top == capacity - 1) {
            System.out.println("Storage is full!");
            return;
        }
        stack[++top] = food;
        System.out.println("Food added: \n" + food);
    }

    /**
     * Removes the top food item from the stack.
     * Time Complexity: O(1)
     */
    @Override
    public void removeFood() {
        if (top == -1) {
            System.out.println("Storage is empty!");
            return;
        }
        Food food = stack[top--];
        System.out.println("Food removed: " + food);
    }

    /**
     * Displays the top element without removing it.
     * Time Complexity: O(1)
     */
    @Override
    public void peekFood() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.println("Top item: " + stack[top]);
    }

    /**
     * Checks if the stack is empty.
     * @return 
     */
    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * Checks if the stack is full.
     * @return 
     */
    @Override
    public boolean isFull() {
        return top == capacity - 1;
    }

    /**
     * Displays all elements in the stack.
     * Time Complexity: O(n)
     */
    @Override
    public void displayFood() {
        if (top == -1) {
            System.out.println("Stack is empty!");
            return;
        }
        System.out.print("\n-- Stack elements contents --\n");
        for (int i = 0; i <= top; i++) {
            System.out.println(stack[i] + " ");
        }
        System.out.println();
    }

    /**
     * Displays number of elements in the stack.
     * Time Complexity: O(1)
     */
    @Override
    public void size() {
        if (isEmpty()) {
            System.out.println("No items in storage.");
        } else {
            System.out.println("Storage contains " + (top + 1) + " item(s).");
        }
    }
}