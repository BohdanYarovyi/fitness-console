package com.yarovyi.app.context;

import com.yarovyi.app.repository.WorkoutRepository;

public class AppContext {
    private final WorkoutRepository workoutRepository;

    public AppContext(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    public WorkoutRepository getWorkoutRepository() {
        return this.workoutRepository;
    }

}
