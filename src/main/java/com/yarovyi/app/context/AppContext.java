package com.yarovyi.app.context;

import com.yarovyi.app.repository.WorkoutRepository;

public class AppContext {
    private final PersistenceService persistenceService;
    private final WorkoutRepository workoutRepository;

    public AppContext(PersistenceService persistenceService, WorkoutRepository workoutRepository) {
        this.persistenceService = persistenceService;
        this.workoutRepository = workoutRepository;
    }

    public PersistenceService getPersistenceService() {
        return this.persistenceService;
    }

    public WorkoutRepository getWorkoutRepository() {
        return this.workoutRepository;
    }

}
