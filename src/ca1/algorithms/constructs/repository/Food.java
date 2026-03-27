package ca1.algorithms.constructs.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface Food {
    String getName();
    double getWeight();
    LocalDate getBestBefore();
    LocalDateTime getTimeStored();
}