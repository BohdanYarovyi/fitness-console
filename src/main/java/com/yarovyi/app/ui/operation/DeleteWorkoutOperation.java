package com.yarovyi.app.ui.operation;

import com.yarovyi.app.exception.UserInputNotValidException;
import com.yarovyi.app.ui.util.Console;
import com.yarovyi.app.entity.Workout;
import com.yarovyi.app.repository.WorkoutRepository;
import io.github.bohdanyarovyi.cli.action.operationManagement.Operation;
import io.github.bohdanyarovyi.cli.context.AppContext;

import java.util.UUID;

import static com.yarovyi.app.ui.consoleConstant.ConsoleMessageTemplates.*;

public class DeleteWorkoutOperation extends Operation {

    @Override
    public void doOperation(String[] args) {
        try {
            UUID id = promptWorkoutId();
            deleteWorkout(id);
            PRINT_MESSAGE.accept("| Workout was deleted");
        } catch (UserInputNotValidException e) {
            PRINT_WARNING.accept("| " + e.getMessage());
        }
    }

    @Override
    public String getDescription() {
        return "Delete workout";
    }

    @Override
    public String getPattern() {
        return "/deleteWorkout";
    }

    private void deleteWorkout(UUID id) throws UserInputNotValidException {
        AppContext context = getApplicationContext();
        WorkoutRepository workoutRepository = context.getComponent("workoutRepository", WorkoutRepository.class);

        if (workoutRepository.existWorkoutById(id)) {
            if (askUserConfirmation(id)){
                workoutRepository.deleteWorkoutById(id);
            }
            return;
        }

        throw new UserInputNotValidException("Workout with such ID does not exist");
    }

    private boolean askUserConfirmation(UUID id) throws UserInputNotValidException {
        AppContext context = getApplicationContext();
        WorkoutRepository workoutRepository = context.getComponent("workoutRepository", WorkoutRepository.class);

        Workout workout = workoutRepository
                .getWorkoutById(id)
                .orElseThrow(() -> new UserInputNotValidException("Workout not found by ID (unexpected error)"));


        String workoutView = FORMAT_WORKOUT.apply(workout);
        String message = workoutView + "| Are you sure to delete workout?";

        return Console.isUserSure(message);
    }

    private UUID promptWorkoutId() throws UserInputNotValidException {
        String userInput = Console.getUserInputWithLabel("| Workout ID for delete:");
        try {
            return UUID.fromString(userInput);
        } catch (IllegalArgumentException e) {
            throw new UserInputNotValidException("Not valid id");
        }
    }

}
