package com.yarovyi.app.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Workout {
    private ExerciseType exerciseType;
    private LocalDate date;
    private int durationMinutes;
    private int caloriesBurned;

    public enum ExerciseType {
        YOGA,
        RUNNING,
        PRESSING,
        SWIMMING
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Workout workout = (Workout) object;

        return durationMinutes == workout.durationMinutes
               && caloriesBurned == workout.caloriesBurned
               && exerciseType == workout.exerciseType
               && Objects.equals(date, workout.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(exerciseType, date, durationMinutes, caloriesBurned);
    }

    @Override
    public String toString() {
        return "Workout{" +
               "exerciseType=" + exerciseType +
               ", date=" + date +
               ", durationMinutes=" + durationMinutes +
               ", caloriesBurned=" + caloriesBurned +
               '}';
    }

}
