package com.yarovyi.app.ui.operation;

import com.yarovyi.app.repository.WorkoutRepository;
import com.yarovyi.app.entity.Workout;
import com.yarovyi.app.exception.UserInputNotValidException;
import io.github.bohdanyarovyi.cli.action.operationManagement.Operation;
import io.github.bohdanyarovyi.cli.context.AppContext;

import java.time.LocalDate;

import static com.yarovyi.app.ui.consoleConstant.ConsoleMessageTemplates.PRINT_MESSAGE;
import static com.yarovyi.app.ui.consoleConstant.ConsoleMessageTemplates.PRINT_WARNING;
import static com.yarovyi.app.ui.util.Console.getUserInputWithLabel;
import static com.yarovyi.app.ui.util.DateUtil.parseDate;

public class CountCaloriesForWeekOperation extends Operation {

    @Override
    public void doOperation(String[] args) {
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
        AppContext context = getApplicationContext();
        WorkoutRepository workoutRepository = context.getComponent("workoutRepository", WorkoutRepository.class);

        return workoutRepository
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
    public String getDescription() {
        return "Show calories for week";
    }

    @Override
    public String getPattern() {
        return "/caloriesForWeek";
    }

}
