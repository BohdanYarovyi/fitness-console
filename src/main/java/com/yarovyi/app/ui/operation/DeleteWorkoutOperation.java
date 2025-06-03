package com.yarovyi.app.ui.operation;

import com.yarovyi.app.exception.UserInputNotValidException;
import com.yarovyi.app.ui.cli.action.operationManagement.Operation;
import com.yarovyi.app.ui.util.Console;
import com.yarovyi.app.ui.cli.context.AppContext;
import com.yarovyi.app.entity.Workout;
import com.yarovyi.app.repository.WorkoutRepository;

import java.util.UUID;

import static com.yarovyi.app.ui.consoleConstant.ConsoleMessageTemplates.*;

public class DeleteWorkoutOperation extends Operation {
    private AppContext appContext;


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

    @Override
    public void setApplicationContext(AppContext context) {
        this.appContext = context;
    }

    private void deleteWorkout(UUID id) throws UserInputNotValidException {
        WorkoutRepository workoutRepository = appContext.getComponent("workoutRepository", WorkoutRepository.class);

        if (workoutRepository.existWorkoutById(id)) {
            if (askUserConfirmation(id)){
                workoutRepository.deleteWorkoutById(id);
            }
            return;
        }

        throw new UserInputNotValidException("Workout with such ID does not exist");
    }

    private boolean askUserConfirmation(UUID id) throws UserInputNotValidException {
        WorkoutRepository workoutRepository = appContext.getComponent("workoutRepository", WorkoutRepository.class);

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
