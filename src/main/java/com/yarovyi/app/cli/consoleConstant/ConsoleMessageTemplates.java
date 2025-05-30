package com.yarovyi.app.cli.consoleConstant;

import com.yarovyi.app.cli.action.commandManagement.command.Command;
import com.yarovyi.app.cli.action.commandManagement.CommandRegister;
import com.yarovyi.app.cli.menu.Menu;
import com.yarovyi.app.cli.action.operationManagement.operation.Operation;
import com.yarovyi.app.cli.action.operationManagement.OperationRegister;
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


    Consumer<String> PRINT_MENU_TITLE = (menuName) -> {
        int width = 40;
        String brackets = "\uD83D\uDCD1";
        String title = brackets + " " + menuName + " " + brackets;

        int sideOffset = (width - title.length()) / 2;
        String sideMargin = " ".repeat(sideOffset);
        System.out.println(sideMargin + title + sideMargin);
    };


    Consumer<List<Menu>> PRINT_LIST_OF_SUBMENUS = (submenus) -> {
        if (submenus.isEmpty()) {
            return;
        }

        String header = "Choose section by entering number:\n";
        String menuItem = "%5d. %s\n";
        StringBuilder menu = new StringBuilder(header);

        for (int i = 0; i < submenus.size(); i++) {
            String sectionName = submenus.get(i).getMenuName();
            menu.append(menuItem.formatted(i + 1, sectionName));
        }

        System.out.print(menu);
    };


    Consumer<OperationRegister> PRINT_LIST_OF_OPERATIONS = (operationRegister) -> {
        Set<Operation> operations = operationRegister.getOperations();
        if (operations.isEmpty()) {
            return;
        }

        String header = "Chose operation:\n";
        String listItemTemplate = "%5s %-20s - %s \n";
        StringBuilder list = new StringBuilder(header);
        for (Operation operation : operations) {
            var pointer = "-";
            var pattern = operation.getOperationPattern();
            var description = operation.getOperationDescription();
            String formatterLine = listItemTemplate.formatted(pointer, pattern, description);

            list.append(formatterLine);
        }

        System.out.print(list);
    };


    Consumer<CommandRegister> PRINT_LIST_OF_COMMANDS = (commandRegister) -> {
        Set<Command> commands = commandRegister.getCommands();
        if (commands.isEmpty()) {
            return;
        }

        String header = "Choose command:\n";
        String listItemTemplate = "%5s %-20s - %s \n";
        StringBuilder list = new StringBuilder();
        list.append(header);
        for (Command command : commands) {
            var pointer = "-";
            var pattern = command.getCommandPattern();
            var description = command.getCommandDescription();
            String formatterLine = listItemTemplate.formatted(pointer, pattern, description);

            list.append(formatterLine);
        }

        System.out.print(list);
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

    Consumer<String> PRINT_CONSOLE_INPUT_PREFIX = (prefix) -> {
        System.out.print(prefix + " ");
    };

    Runnable PRINT_CONSOLE_SEPARATOR = () -> System.out.println("-".repeat(40) + "\n");

}
