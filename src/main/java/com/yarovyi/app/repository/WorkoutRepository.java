package com.yarovyi.app.repository;

import com.yarovyi.app.entity.Workout;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface WorkoutRepository {

    List<Workout> getAllWorkouts();
    List<Workout> getWorkoutsForWeekStartsFromDate(LocalDate date);
    List<Workout> getWorkoutsForMonth(YearMonth month);
    Optional<Workout> getWorkoutById(UUID id);
    UUID addWorkout(Workout workout);
    void deleteWorkoutById(UUID id);
    boolean existWorkoutWithDate(LocalDate date);
    boolean existWorkoutById(UUID id);

}
