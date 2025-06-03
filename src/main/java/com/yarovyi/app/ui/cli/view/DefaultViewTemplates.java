package com.yarovyi.app.ui.cli.view;

import com.yarovyi.app.ui.cli.action.commandManagement.Command;
import com.yarovyi.app.ui.cli.action.commandManagement.CommandRegister;
import com.yarovyi.app.ui.cli.action.operationManagement.Operation;
import com.yarovyi.app.ui.cli.action.operationManagement.OperationRegister;
import com.yarovyi.app.ui.cli.menu.Menu;

import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

public interface DefaultViewTemplates {

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
            var pattern = operation.getPattern();
            var description = operation.getDescription();
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
            var pattern = command.getPattern();
            var description = command.getDescription();
            String formatterLine = listItemTemplate.formatted(pointer, pattern, description);

            list.append(formatterLine);
        }

        System.out.print(list);
    };

}
