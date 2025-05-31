package com.yarovyi.app.ui.action.operationManagement.operation;

import com.yarovyi.app.context.AppContext;
import com.yarovyi.app.entity.Workout;
import com.yarovyi.app.ui.exception.UserInputNotValidException;
import com.yarovyi.app.ui.util.Console;

import java.time.YearMonth;

import static com.yarovyi.app.ui.consoleConstant.ConsoleMessageTemplates.PRINT_MESSAGE;
import static com.yarovyi.app.ui.consoleConstant.ConsoleMessageTemplates.PRINT_WARNING;
import static com.yarovyi.app.ui.util.DateUtil.*;

public class CountCaloriesForMonthOperation extends Operation {
    private AppContext appContext;


    @Override
    public void doOperation() {
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
        return this.appContext
                .getWorkoutRepository()
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
    public String getOperationDescription() {
        return "Show calories for month";
    }

    @Override
    public String getOperationPattern() {
        return "/caloriesForMonth";
    }

    @Override
    public void setApplicationContext(AppContext context) {
        this.appContext = context;
    }

}
