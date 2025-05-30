package com.yarovyi.app.repository;

import com.yarovyi.app.entity.Workout;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class WorkoutRepositoryImpl implements WorkoutRepository {
    private final Map<UUID, Workout> workouts = new HashMap<>();

    @Override
    public List<Workout> getAllWorkouts() {
        return workouts.values().stream()
                .map(Workout::new)
                .toList();
    }

    @Override
    public Optional<Workout> getWorkoutById(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("id is null");
        }

        Workout workout = workouts.get(id);

        return Optional
                .ofNullable(workout)
                .map(Workout::new);
    }

    @Override
    public UUID addWorkout(Workout workout) {
        if (workout.getId() != null) {
            throw new IllegalArgumentException("Failed to create workout cause id must be null");
        }

        UUID id = UUID.randomUUID();
        workout.setId(id);

        this.workouts.put(id, workout);
        return id;
    }

    @Override
    public void deleteWorkoutById(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("id is null");
        }

        this.workouts.remove(id);
    }

    @Override
    public boolean existWorkoutWithDate(LocalDate date) {
        return this.workouts.values().stream()
                .anyMatch(w -> Objects.equals(w.getDate(), date));
    }

    @Override
    public boolean existWorkoutById(UUID id) {
        return this.workouts.containsKey(id);
    }

}
