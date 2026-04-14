package ca1.algorithms.constructs.enums;

import ca1.algorithms.constructs.repository.FoodStorage;
import ca1.algorithms.constructs.model.Queue;
import ca1.algorithms.constructs.model.Stack;

/**
 *
 * @author Gustavo
 */
public enum StorageTypeEnum {

    STACK("Stack Storage", "(Push)", "(Pop)") {
        @Override
        public FoodStorage create() {
            return new Stack(8);
        }
    },
    QUEUE("Queue Storage", "(Enqueue)", "(Dequeue)") {
        @Override
        public FoodStorage create() {
            return new Queue(8);
        }
    };

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

    public abstract FoodStorage create();

    public static StorageTypeEnum fromChoice(int choice) {
        return switch (choice) {
            case 1 ->STACK;
            case 2 ->QUEUE;
            default -> throw new IllegalArgumentException(
                        "Invalid choice: " + choice);
        };
    }
}