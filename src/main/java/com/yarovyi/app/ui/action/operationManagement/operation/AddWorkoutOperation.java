package com.yarovyi.app.ui.action.operationManagement.operation;

import com.yarovyi.app.ui.exception.UserInputNotValidException;
import com.yarovyi.app.ui.util.Console;
import com.yarovyi.app.context.AppContext;
import com.yarovyi.app.entity.Workout;
import com.yarovyi.app.repository.WorkoutRepository;

import java.time.LocalDate;
import java.util.UUID;

import static com.yarovyi.app.ui.consoleConstant.ConsoleMessageTemplates.*;

public class AddWorkoutOperation extends Operation {
    private AppContext appContext;

    @Override
    public void doOperation() {
        WorkoutRepository workoutRepository = appContext.getWorkoutRepository();

        try {
            Workout.ExerciseType exerciseType = getExerciseType();
            LocalDate date = getDate();
            int durationMinutes = getPositiveNumberWithLabel("Duration minutes:");
            int caloriesBurned = getPositiveNumberWithLabel("Calories burned:");

            Workout workout = new Workout(exerciseType, date, durationMinutes, caloriesBurned);
            UUID id = workoutRepository.addWorkout(workout);
            PRINT_MESSAGE.accept("Workout successfully created with id: " + id);
        } catch (UserInputNotValidException e) {
            PRINT_WARNING.accept("Failed to create workout: " + e.getMessage());
        }
    }

    @Override
    public String getOperationDescription() {
        return "Add Workout";
    }

    @Override
    public String getOperationPattern() {
        return "/addWorkout";
    }

    @Override
    public void setApplicationContext(AppContext context) {
        this.appContext = context;
    }

    protected Workout.ExerciseType getExerciseType() throws UserInputNotValidException {
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

    protected LocalDate getDate() throws UserInputNotValidException {
        WorkoutRepository workoutRepository = this.appContext.getWorkoutRepository();
        String userInput = Console.getUserInputWithLabel("| Date:");
        LocalDate date = parseDate(userInput);

        if (workoutRepository.existWorkoutWithDate(date)) {
            throw new UserInputNotValidException("Workout with such date already exists");
        }

        return date;
    }

    protected LocalDate parseDate(String stringDate) throws UserInputNotValidException {
        String[] dateNumbers = stringDate.split("\\.");

        if (dateNumbers.length != 3) {
            throw new UserInputNotValidException("Input not valid, use yyyy.mm.dd format: " + stringDate);
        }
        try {
            int year = Integer.parseInt(dateNumbers[0]);
            int month = Integer.parseInt(dateNumbers[1]);
            int day = Integer.parseInt(dateNumbers[2]);

            return LocalDate.of(year, month, day);
        } catch (NumberFormatException e) {
            throw new UserInputNotValidException("Entered date not valid. Please use integers for input");
        }
    }

    protected int getPositiveNumberWithLabel(String label) throws UserInputNotValidException {
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
