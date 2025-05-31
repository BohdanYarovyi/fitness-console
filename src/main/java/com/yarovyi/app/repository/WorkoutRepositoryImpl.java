package com.yarovyi.app.repository;

import com.yarovyi.app.entity.Workout;
import com.yarovyi.app.exception.ObjectLoadingException;
import com.yarovyi.app.exception.ObjectSavingException;
import com.yarovyi.app.repository.persistence.EntityStorage;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.*;

import static com.yarovyi.app.ui.consoleConstant.ConsoleMessageTemplates.PRINT_ERROR;

public class WorkoutRepositoryImpl implements WorkoutRepository, PersistenceRepository {
    private final Map<UUID, Workout> workouts = new HashMap<>();
    private final EntityStorage<Workout> workoutStorage;

    public WorkoutRepositoryImpl(EntityStorage<Workout> workoutStorage) {
        this.workoutStorage = workoutStorage;
    }

    @Override
    public List<Workout> getAllWorkouts() {
        return workouts.values().stream()
                .map(Workout::new)
                .toList();
    }

    @Override
    public List<Workout> getWorkoutsForWeekStartsFromDate(LocalDate date) {
        if (date == null) {
            throw new IllegalArgumentException("date is null");
        }

        LocalDate start = date.minusDays(1);
        LocalDate end = date.plusDays(7);
        List<Workout> workouts = new ArrayList<>(this.workouts.values());
        List<Workout> result = new ArrayList<>();
        for (Workout w : workouts) {
            if (w.getDate().isAfter(start) && w.getDate().isBefore(end)) {
                result.add(w);
            }
        }

        return result;
    }

    @Override
    public List<Workout> getWorkoutsForMonth(YearMonth month) {
        if (month == null) {
            throw new IllegalArgumentException("month is null");
        }

        return this.workouts.values().stream()
                .filter(w -> YearMonth.from(w.getDate()).equals(month))
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

    @Override
    public void load() {
        try {
            List<Workout> saves = this.workoutStorage.load();

            for (Workout save : saves) {
                this.workouts.put(save.getId(), save);
            }
        } catch (ObjectLoadingException e) {
            System.out.println("Failed to load workouts: " + e.getMessage());
        }
    }

    @Override
    public void save() {
        try {
            List<Workout> workouts = new ArrayList<>(this.workouts.values());

            workoutStorage.save(workouts);
        } catch (ObjectSavingException e) {
            System.out.println("Failed to save workouts: " + e.getMessage());
        }
    }

}
