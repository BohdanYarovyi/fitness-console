package com.yarovyi.app.ui.operation;

import com.yarovyi.app.repository.WorkoutRepository;
import com.yarovyi.app.entity.Workout;
import com.yarovyi.app.exception.UserInputNotValidException;
import com.yarovyi.app.ui.util.Console;
import io.github.bohdanyarovyi.cli.action.operationManagement.Operation;
import io.github.bohdanyarovyi.cli.context.AppContext;

import java.time.YearMonth;

import static com.yarovyi.app.ui.consoleConstant.ConsoleMessageTemplates.PRINT_MESSAGE;
import static com.yarovyi.app.ui.consoleConstant.ConsoleMessageTemplates.PRINT_WARNING;
import static com.yarovyi.app.ui.util.DateUtil.*;

public class CountCaloriesForMonthOperation extends Operation {


    @Override
    public void doOperation(String[] args) {
        try {
            YearMonth month = promptMonthAndYear();
            int calories = countCaloriesForMonth(month);

            String messageTmp = "| Sum of calories for %s %s is %s";
            PRINT_MESSAGE.accept(messageTmp.formatted(month.getMonth(), month.getYear(), calories));
        } catch (UserInputNotValidException e) {
            PRINT_WARNING.accept("| " + e.getMessage());
        }
    }

    private int countCaloriesForMonth(YearMonth yearMonth) {
        AppContext context = getApplicationContext();
        WorkoutRepository workoutRepository = context.getComponent("workoutRepository", WorkoutRepository.class);

        return workoutRepository
                .getWorkoutsForMonth(yearMonth)
                .stream()
                .mapToInt(Workout::getCaloriesBurned)
                .sum();
    }

    private YearMonth promptMonthAndYear() throws UserInputNotValidException {
        String message = "| Enter year and month to count burned calories for this period (yyyy.mm)";
        PRINT_MESSAGE.accept(message);

        String userInput = Console.getUserInputWithLabel("| Year and month: ");
        return parseYearMonth(userInput);
    }

    @Override
    public String getDescription() {
        return "Show calories for month";
    }

    @Override
    public String getPattern() {
        return "/caloriesForMonth";
    }

}
