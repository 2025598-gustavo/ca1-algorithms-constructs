package ca1.algorithms.constructs.model;

import ca1.algorithms.constructs.repository.FoodStorage;
import ca1.algorithms.constructs.repository.Food;

/**
 * Queue implementation using an array.
 * This follows the FIFO (First In First Out) principle:
 * The first element added is the first to be removed.
 */
public class Queue implements FoodStorage {
    private final Food[] queue; // Array to store food items
    private final int size;     // Maximum capacity of the queue
    private int front, rear;    // Pointers to track positions

    /**
     * Constructor initializes queue with given size.
     * @param size
     */
    public Queue(int size) {
        this.size = size;
        this.queue = new Food[size];
        this.front = -1;
        this.rear = -1;
    }

    /**
     * Checks if the queue is empty.
     * @return true if empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return front == -1;
    }

    /**
     * Checks if the queue is full.
     * @return true if full, false otherwise
     */
    @Override
    public boolean isFull() {
        return rear == size - 1;
    }

    /**
     * Adds a food item to the rear of the queue.
     * Time Complexity: O(1)
     */
    @Override
    public void addFood(Food food) {
        if (isFull()) {
            System.out.println("Storage is full!");
        } else {
            if (front == -1) {
                front = 0; // Initialize front when first element is added
            }
            
            rear++;
            queue[rear] = food;
            System.out.println("Food added: \n" + food);
        }
    }

    /**
     * Removes a food item from the front of the queue.
     * Time Complexity: O(1)
     */
    @Override
    public void removeFood() {
        if (isEmpty()) {
            System.out.println("Storage is empty!");
        } else {
            Food food = queue[front];

            // If only one element, reset queue
            if (front == rear) {
                front = rear = -1; // Reset queue after last food is dequeued
            } else {
                front++;
            }

            System.out.println("Food removed: " + food);
        }
    }

    /**
     * Displays the front element without removing it.
     * Time Complexity: O(1)
     */
    @Override
    public void peekFood() {
        if (isEmpty()) {
            System.out.println("Storage is empty!");
        } else {
            System.out.println("Front of the storage: " + queue[front]);
        }
    }

    /**
     * Displays all elements in the queue.
     * Time Complexity: O(n)
     */
    @Override
    public void displayFood() {
        if (isEmpty()) {
            System.out.println("Storage is empty!");
        } else {
            System.out.print("\n-- Queue elements contents --\n");
            for (int i = front; i <= rear; i++) {
                System.out.println(queue[i] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Displays the number of elements in the queue.
     * Time Complexity: O(1)
     */
    @Override
    public void size() {
        if (isEmpty()) {
            System.out.println("No items in storage.");
        } else {
            System.out.println("Storage contains " + (rear - front + 1) + 
                    " item(s).");
        }
    }
}