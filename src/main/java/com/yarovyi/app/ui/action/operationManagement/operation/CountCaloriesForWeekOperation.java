package com.yarovyi.app.ui.action.operationManagement.operation;

import com.yarovyi.app.context.AppContext;
import com.yarovyi.app.entity.Workout;
import com.yarovyi.app.ui.exception.UserInputNotValidException;

import java.time.LocalDate;

import static com.yarovyi.app.ui.consoleConstant.ConsoleMessageTemplates.PRINT_MESSAGE;
import static com.yarovyi.app.ui.consoleConstant.ConsoleMessageTemplates.PRINT_WARNING;
import static com.yarovyi.app.ui.util.Console.getUserInputWithLabel;
import static com.yarovyi.app.ui.util.DateUtil.parseDate;

public class CountCaloriesForWeekOperation extends Operation {
    private AppContext appContext;

    @Override
    public void doOperation() {
        try {
            LocalDate date = promptDate();
            int calories = countCaloriesForWeek(date);

            String messageTmp = "| Sum of calories for week starts from %s is %d\n";
            PRINT_MESSAGE.accept(messageTmp.formatted(date, calories));
        } catch (UserInputNotValidException e) {
            PRINT_WARNING.accept("| " + e.getMessage());
        }
    }

    private int countCaloriesForWeek(LocalDate date) {
        return  this.appContext
                .getWorkoutRepository()
                .getWorkoutsForWeekStartsFromDate(date)
                .stream()
                .mapToInt(Workout::getCaloriesBurned)
                .sum();
    }

    private LocalDate promptDate() throws UserInputNotValidException {
        String message = "| Enter the date to calculate the calories for the week starting from that day (yyyy.MM.dd)";
        PRINT_MESSAGE.accept(message);

        String userInput = getUserInputWithLabel("| Date: ");
        return parseDate(userInput);
    }

    @Override
    public String getOperationDescription() {
        return "Show calories for week";
    }

    @Override
    public String getOperationPattern() {
        return "/caloriesForWeek";
    }

    @Override
    public void setApplicationContext(AppContext context) {
        this.appContext = context;
    }

}
