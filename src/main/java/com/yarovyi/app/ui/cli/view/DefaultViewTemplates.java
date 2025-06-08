package com.yarovyi.app.ui.cli.view;

import com.yarovyi.app.ui.cli.action.commandManagement.command.Command;
import com.yarovyi.app.ui.cli.action.commandManagement.CommandRegister;
import com.yarovyi.app.ui.cli.action.operationManagement.Operation;
import com.yarovyi.app.ui.cli.action.operationManagement.OperationRegister;
import com.yarovyi.app.ui.cli.menu.Menu;

import java.util.List;
import java.util.Set;
import java.util.function.Consumer;


/**
 * Provides console view templates for printing formatted menu content.
 *
 * @since 1.0
 * @author Bohdan Yarovyi
 */
public interface DefaultViewTemplates {

    /**
     * Prints menu title based on name of menu.
     * <p>
     * Lambda gets menu name and compose it at the center of row with width 40 symbols.
     * Row has emoji like brackets.
     * </p>
     * <h5>Example:</h5>
     * <pre>
     *               📑 Lobby 📑
     * </pre>
     * <h6>or</h6>
     * <pre>
     *             📑 Statistics 📑
     * </pre>
     */
    Consumer<String> PRINT_MENU_TITLE = (menuName) -> {
        int width = 40;
        String brackets = "\uD83D\uDCD1";
        String title = brackets + " " + menuName + " " + brackets;

        int sideOffset = (width - title.length()) / 2;
        String sideMargin = " ".repeat(sideOffset);
        System.out.println(sideMargin + title + sideMargin);
    };

    /**
     * Prints list of submenu in comfort view.
     * <p>
     * Lambda gets a list of submenu, build a marked list and print.
     * </p>
     * <h5>Example:</h5>
     * <pre>
     * Choose section by entering number:
     *     1. Statistics
     *     2. Workout management
     * </pre>
     */
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

    /**
     * Print list of operations.
     * <p>
     *     In different menu user has different options.
     *     Lambda composes a list of operation, that user available to do in this menu.
     * </p>
     * <h5>Example:</h5>
     * <pre>
     * Chose operation:
     *     - /showWorkouts        - Show all workouts
     *     - /deleteWorkout       - Delete workout
     *     - /addWorkout          - Add Workout
     * </pre>
     */
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
            var pattern = operation.getPattern();
            var description = operation.getDescription();
            String formatterLine = listItemTemplate.formatted(pointer, pattern, description);

            list.append(formatterLine);
        }

        System.out.print(list);
    };

    /**
     * Print list of commands.
     * <p>
     *     In different menu user has different commands.
     *     Lambda composes a list of commands, that user available to do in this menu.
     * </p>
     * <h5>Example:</h5>
     * <pre>
     * Choose command:
     *     - /back                - Back to previous menu
     *     - /exit                - Urgent exit from the program
     * </pre>
     */
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
            var pattern = command.getPattern();
            var description = command.getDescription();
            String formatterLine = listItemTemplate.formatted(pointer, pattern, description);

            list.append(formatterLine);
        }

        System.out.print(list);
    };

    /**
     * Prints a long line of '-' as a separator.
     */
    Runnable PRINT_CONSOLE_SEPARATOR = () -> System.out.println("-".repeat(40) + "\n");

    Consumer<String> PRINT_MESSAGE = System.out::println;

}
