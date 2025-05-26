package com.yarovyi.app.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Workout {
    private ExerciseType exerciseType;
    private LocalDate date;
    private int durationMinutes;
    private int caloriesBurned;

    public Workout() {}

    public Workout(ExerciseType exerciseType, LocalDate date, int durationMinutes, int caloriesBurned) {
        this.exerciseType = exerciseType;
        this.date = date;
        this.durationMinutes = durationMinutes;
        this.caloriesBurned = caloriesBurned;
    }

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
        return "WorkoutMenu{" +
               "exerciseType=" + exerciseType +
               ", date=" + date +
               ", durationMinutes=" + durationMinutes +
               ", caloriesBurned=" + caloriesBurned +
               '}';
    }

    public ExerciseType getExerciseType() {
        return exerciseType;
    }

    public void setExerciseType(ExerciseType exerciseType) {
        this.exerciseType = exerciseType;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public int getCaloriesBurned() {
        return caloriesBurned;
    }

    public void setCaloriesBurned(int caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }

}
