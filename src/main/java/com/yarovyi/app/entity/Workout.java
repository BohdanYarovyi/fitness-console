package com.yarovyi.app.entity;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Workout {
    private UUID id;
    private ExerciseType exerciseType;
    private LocalDate date;
    private int durationMinutes;
    private int caloriesBurned;

    public Workout() {}

    public Workout(Workout other) {
        this(other.getId(), other.exerciseType, other.date, other.durationMinutes, other.caloriesBurned);
    }

    public Workout(ExerciseType exerciseType, LocalDate date, int durationMinutes, int caloriesBurned) {
        this(null, exerciseType, date, durationMinutes, caloriesBurned);
    }

    public Workout(UUID id, ExerciseType exerciseType, LocalDate date, int durationMinutes, int caloriesBurned) {
        this.id = id;
        this.exerciseType = exerciseType;
        this.date = date;
        this.durationMinutes = durationMinutes;
        this.caloriesBurned = caloriesBurned;
    }

    public enum ExerciseType {
        RUNNING,
        CYCLING,
        SWIMMING,
        YOGA,
        WALKING,
        PRESSING,
        GYM,
        BOXING,
        DANCING,
        HIIT,
        PILATES,
        DANCE
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Workout workout = (Workout) object;

        return Objects.equals(id , workout.id)
               && Objects.equals(date, workout.date)
               && durationMinutes == workout.durationMinutes
               && caloriesBurned == workout.caloriesBurned
               && exerciseType == workout.exerciseType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, exerciseType, date, durationMinutes, caloriesBurned);
    }

    @Override
    public String toString() {
        return "Workout{" +
               "id=" + id +
               ", exerciseType=" + exerciseType +
               ", date=" + date +
               ", durationMinutes=" + durationMinutes +
               ", caloriesBurned=" + caloriesBurned +
               '}';
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
