package ca1.algorithms.constructs.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Interface representing a Food entity.
 * Defines the required attributes for any food item.
 */
public interface Food {
    String getName();
    double getWeight();
    LocalDate getBestBefore();
    LocalDateTime getTimeStored();
}