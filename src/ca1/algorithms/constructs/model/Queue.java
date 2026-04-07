package ca1.algorithms.constructs.model;

import ca1.algorithms.constructs.repository.Food;
import ca1.algorithms.constructs.repository.FoodStorage;

public class Queue implements FoodStorage {
    private Food[] queue;
    private int front, rear, size;

    public Queue(int size) {
        this.size = size;
        this.queue = new Food[size];
        this.front = -1;
        this.rear = -1;
    }

    @Override
    public boolean isEmpty() {
        return front == -1;
    }

    @Override
    public boolean isFull() {
        return rear == size - 1;
    }

    @Override
    public void addFood(Food food) {
        if (isFull()) {
            System.out.println("Storage is full!");
        } else {
            if (front == -1) {
                front = 0;
            }
            rear++;
            queue[rear] = food;
            System.out.println("Food added: " + food);
        }
    }

    @Override
    public void removeFood() {
        if (isEmpty()) {
            System.out.println("Storage is empty!");
        } else {
            Food food = queue[front];
            if (front == rear) {
                front = rear = -1; // Reset queue after last food is dequeued
            } else {
                front++;
            }
            System.out.println("Food removed: " + food);
        }
    }

    @Override
    public void peekFood() {
        if (isEmpty()) {
            System.out.println("Storage is empty!");
        } else {
            System.out.println("Front of the storage: " + queue[front]);
        }
    }

    @Override
    public void displayFood() {
        if (isEmpty()) {
            System.out.println("Storage is empty!");
        } else {
            System.out.print("Storage contents: ");
            for (int i = front; i <= rear; i++) {
                System.out.print(queue[i] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void size() {
        if (isEmpty()) {
            System.out.println("Storage size: 0");
        } else {
            System.out.println("Storage size: " + (rear - front + 1));
        }
    }
}