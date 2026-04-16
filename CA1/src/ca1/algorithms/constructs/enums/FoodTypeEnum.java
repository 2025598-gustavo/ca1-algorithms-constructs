package ca1.algorithms.constructs.enums;

/**
 * Enum representing the allowed food types in the system.
 * Restricts input to only valid predefined values.
 */
public enum FoodTypeEnum {
    BURGER("Burger"),
    PIZZA("Pizza"),
    FRIES("Fries"),
    SANDWICH("Sandwich"),
    HOTDOG("Hotdog");

    private final String displayName;

    FoodTypeEnum(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    /**
     * Converts user input into enum.
     * @param choice
     * @return 
     */
    public static FoodTypeEnum fromChoice(int choice) {
        return switch (choice) {
            case 1 -> BURGER;
            case 2 -> PIZZA;
            case 3 -> FRIES;
            case 4 -> SANDWICH;
            case 5 -> HOTDOG;
            default -> throw new IllegalArgumentException("Invalid food choice!");
        };
    }
}