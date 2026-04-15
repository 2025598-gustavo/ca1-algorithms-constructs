package ca1.algorithms.constructs.enums;

import ca1.algorithms.constructs.repository.FoodStorage;
import ca1.algorithms.constructs.model.Queue;
import ca1.algorithms.constructs.model.Stack;

/**
 * Enum representing available storage types.
 * It encapsulates behavior and metadata for each structure.
 */
public enum StorageTypeEnum {

    // Stack implementation (LIFO)
    STACK("Stack Storage", "(Push)", "(Pop)") {
        @Override
        public FoodStorage create() {
            return new Stack(8); // Creates Stack with fixed capacity
        }
    },

    // Queue implementation (FIFO)
    QUEUE("Queue Storage", "(Enqueue)", "(Dequeue)") {
        @Override
        public FoodStorage create() {
            return new Queue(8); // Creates Queue with fixed capacity
        }
    };

    // Display name and operation labels
    private final String storageName;
    private final String addLabel;
    private final String removeLabel;

    StorageTypeEnum(String storageName, String addLabel, String removeLabel) {
        this.storageName = storageName;
        this.addLabel = addLabel;
        this.removeLabel = removeLabel;
    }

    public String getStorageName() {
        return storageName;
    }

    public String getAddLabel() {
        return addLabel;
    }

    public String getRemoveLabel() {
        return removeLabel;
    }

    // Factory method to create correct structure
    public abstract FoodStorage create();

    /**
     * Converts user input into corresponding enum value.
     * Throws exception if invalid input is provided.
     */
    public static StorageTypeEnum fromChoice(int choice) {
        return switch (choice) {
            case 1 -> STACK;
            case 2 -> QUEUE;
            default -> throw new IllegalArgumentException(
                        "Invalid choice: " + choice);
        };
    }
}