package com.yarovyi.app.ui.operation;

import com.yarovyi.app.exception.UserInputNotValidException;
import com.yarovyi.app.ui.util.Console;
import com.yarovyi.app.entity.Workout;
import com.yarovyi.app.repository.WorkoutRepository;
import io.github.bohdanyarovyi.cli.action.operationManagement.Operation;
import io.github.bohdanyarovyi.cli.context.AppContext;

import java.time.LocalDate;
import java.util.UUID;

import static com.yarovyi.app.ui.consoleConstant.ConsoleMessageTemplates.*;
import static com.yarovyi.app.ui.util.DateUtil.parseDate;

public class AddWorkoutOperation extends Operation {

    @Override
    public void doOperation(String[] args) {
        AppContext context = getApplicationContext();
        WorkoutRepository workoutRepository = context.getComponent("workoutRepository", WorkoutRepository.class);

        try {
            Workout.ExerciseType exerciseType = promptExerciseType();
            LocalDate date = promptDate();
            int durationMinutes = promptPositiveNumberWithLabel("Duration minutes:");
            int caloriesBurned = promptPositiveNumberWithLabel("Calories burned:");

            Workout workout = new Workout(exerciseType, date, durationMinutes, caloriesBurned);
            UUID id = workoutRepository.addWorkout(workout);
            PRINT_MESSAGE.accept("Workout successfully created with id: " + id);
        } catch (UserInputNotValidException e) {
            PRINT_WARNING.accept("| " + e.getMessage());
        }
    }

    @Override
    public String getDescription() {
        return "Add Workout";
    }

    @Override
    public String getPattern() {
        return "/addWorkout";
    }

    protected Workout.ExerciseType promptExerciseType() throws UserInputNotValidException {
        Workout.ExerciseType[] types = Workout.ExerciseType.values();
        PRINT_LIST_OF_EXERCISE_TYPE.accept(types);

        try {
            String userInput = Console.getUserInputWithLabel("| Exercise type:");
            int number = Integer.parseInt(userInput);
            return types[number - 1];
        } catch (NumberFormatException e) {
            throw new UserInputNotValidException("You must enter number to choose exercise type.");
        } catch (IndexOutOfBoundsException e) {
            throw new UserInputNotValidException("Such option does not exist");
        }
    }

    protected LocalDate promptDate() throws UserInputNotValidException {
        AppContext context = getApplicationContext();
        WorkoutRepository workoutRepository = context.getComponent("workoutRepository", WorkoutRepository.class);

        String userInput = Console.getUserInputWithLabel("| Date:");
        LocalDate date = parseDate(userInput);

        if (workoutRepository.existWorkoutWithDate(date)) {
            throw new UserInputNotValidException("Workout with such date already exists");
        }

        return date;
    }

    protected int promptPositiveNumberWithLabel(String label) throws UserInputNotValidException {
        String userInput = Console.getUserInputWithLabel("| " + label);

        try {
            int number = Integer.parseInt(userInput);
            if (number < 1) {
                throw new UserInputNotValidException("Input value must be positive number, but it is: " + userInput);
            }

            return number;
        } catch (NumberFormatException e) {
            throw new UserInputNotValidException("Input value is not a number: " + userInput);
        }
    }

}
