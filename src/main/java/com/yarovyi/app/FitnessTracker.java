package com.yarovyi.app;

import com.yarovyi.app.entity.Workout;

import java.time.LocalDate;

public class FitnessTracker {

    public static void main(String[] args) {
        Workout w = new Workout();
        w.setExerciseType(Workout.ExerciseType.RUNNING);
        w.setDate(LocalDate.now());
        w.setDurationMinutes(200);
        w.setCaloriesBurned(1200);

        System.out.println(w);
    }

}
