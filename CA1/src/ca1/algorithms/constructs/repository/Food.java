package ca1.algorithms.constructs.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author Gustavo
 */
public interface Food {
    String getName();
    double getWeight();
    LocalDate getBestBefore();
    LocalDateTime getTimeStored();
}