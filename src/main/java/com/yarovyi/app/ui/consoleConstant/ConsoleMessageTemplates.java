package com.yarovyi.app.ui.consoleConstant;

import com.yarovyi.app.ui.cli.action.commandManagement.Command;
import com.yarovyi.app.ui.cli.action.commandManagement.CommandRegister;
import com.yarovyi.app.ui.cli.menu.Menu;
import com.yarovyi.app.ui.cli.action.operationManagement.Operation;
import com.yarovyi.app.ui.cli.action.operationManagement.OperationRegister;
import com.yarovyi.app.entity.Workout;

import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

public interface ConsoleMessageTemplates {
    Runnable PRINT_WELCOME = () -> {
        String template = """
                💪 Welcome to Fitness Tracker 💪
                Here you able to manage your fitness progress and see your calories for special period.
                Now it is not persistence application, but you can test MVP version now.
                
                """;

        System.out.print(template);
    };

    Consumer<Workout.ExerciseType[]> PRINT_LIST_OF_EXERCISE_TYPE = (types) -> {
        String header = "| Choose exercise type:\n";
        String itemTmp = "| %5d %-20s\n";
        StringBuilder text = new StringBuilder();

        text.append(header);
        for (int i = 0; i < types.length; i++) {
            String item = itemTmp.formatted(i + 1, types[i].name());
            text.append(item);
        }

        System.out.print(text);
    };

    Function<Workout, String> FORMAT_WORKOUT = (workout) -> {
        String rowTmp = "| %-20s %s\n";

        return rowTmp.formatted("Id", workout.getId()) +
               rowTmp.formatted("Date", workout.getDate()) +
               rowTmp.formatted("Exercise type", workout.getExerciseType()) +
               rowTmp.formatted("Duration minutes", workout.getDurationMinutes()) +
               rowTmp.formatted("Calories burned", workout.getCaloriesBurned());
    };

    Consumer<String> PRINT_MESSAGE = System.out::println;

    Consumer<String> PRINT_WARNING = (message) -> {
        System.out.println("WARNING: " + message);
    };

    Consumer<String> PRINT_ERROR = (message) -> {
        System.out.println("ERROR: " + message);
    };

    Consumer<String> PRINT_CONSOLE_INPUT_PREFIX = (prefix) -> {
        System.out.print(prefix + " ");
    };

    Runnable PRINT_CONSOLE_SEPARATOR = () -> System.out.println("-".repeat(40) + "\n");

}
