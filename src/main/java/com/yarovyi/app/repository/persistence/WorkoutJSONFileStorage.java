package com.yarovyi.app.repository.persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yarovyi.app.entity.Workout;
import com.yarovyi.app.exception.ObjectLoadingException;
import com.yarovyi.app.exception.ObjectSavingException;

import java.io.*;
import java.util.List;

public class WorkoutJSONFileStorage implements EntityStorage<Workout> {
    public static final String SAVES_PATH = "workouts.json";
    private final ObjectMapper mapper = new ObjectMapper();
    private final FileService fileService;

    public WorkoutJSONFileStorage(FileService fileService) {
        this.fileService = fileService;

        mapper.findAndRegisterModules();
    }

    @Override
    public List<Workout> load() throws ObjectLoadingException {
        try {
            File file = new File(SAVES_PATH);
            String json = this.fileService.readFile(file);

            if (json == null || json.isBlank()) {
                return List.of();
            }

            Workout[] workouts = this.mapper.readValue(json, Workout[].class);
            System.out.println("-- All persistence entities were loaded");

            return List.of(workouts);
        } catch (IOException e) {
            throw new ObjectLoadingException("Failed to load workout from file", e);
        }
    }

    @Override
    public void save(List<Workout> entities) throws ObjectSavingException {
        try {
            File file = new File(SAVES_PATH);
            String json = this.mapper.writeValueAsString(entities);

            this.fileService.writeToFile(json, file);
            System.out.println("-- All persistence entities ware saved");
        } catch (IOException e) {
            throw new ObjectSavingException("Failed to save workouts to file", e);
        }
    }

}
