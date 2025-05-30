package com.yarovyi.app.cli.action.operationManagement.operation;

import com.yarovyi.app.cli.exception.UserInputNotValidException;
import com.yarovyi.app.cli.util.Console;
import com.yarovyi.app.context.AppContext;
import com.yarovyi.app.entity.Workout;
import com.yarovyi.app.repository.WorkoutRepository;

import java.util.UUID;

import static com.yarovyi.app.cli.consoleConstant.ConsoleMessageTemplates.FORMAT_WORKOUT;
import static com.yarovyi.app.cli.consoleConstant.ConsoleMessageTemplates.PRINT_WARNING;

public class DeleteWorkoutOperation extends Operation {
    private AppContext appContext;


    @Override
    public void doOperation() {
        try {
            UUID id = getWorkoutId();
            deleteWorkout(id);
        } catch (UserInputNotValidException e) {
            PRINT_WARNING.accept(e.getMessage());
        }
    }

    @Override
    public String getOperationDescription() {
        return "Delete workout";
    }

    @Override
    public String getOperationPattern() {
        return "/deleteWorkout";
    }

    @Override
    public void setApplicationContext(AppContext context) {
        this.appContext = context;
    }

    private void deleteWorkout(UUID id) throws UserInputNotValidException {
        WorkoutRepository workoutRepository = appContext.getWorkoutRepository();
        if (workoutRepository.existWorkoutById(id)) {
            if (askUserConfirmation(id)){
                workoutRepository.deleteWorkoutById(id);
            }
            return;
        }

        throw new UserInputNotValidException("Workout with such ID does not exist");
    }

    private boolean askUserConfirmation(UUID id) throws UserInputNotValidException {
        WorkoutRepository workoutRepository = appContext.getWorkoutRepository();

        Workout workout = workoutRepository
                .getWorkoutById(id)
                .orElseThrow(() -> new UserInputNotValidException("Workout not found by ID (unexpected error)"));


        String workoutView = FORMAT_WORKOUT.apply(workout);
        String message = workoutView + "Are you sure to delete workout?";

        return Console.isUserSure(message);
    }

    private UUID getWorkoutId() throws UserInputNotValidException {
        String userInput = Console.getUserInputWithLabel("| Workout ID for delete:");
        try {
            return UUID.fromString(userInput);
        } catch (IllegalArgumentException e) {
            throw new UserInputNotValidException("Not valid id");
        }
    }

}
