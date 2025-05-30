package com.yarovyi.app.cli.menu;

import com.yarovyi.app.cli.action.commandManagement.CommandRegister;
import com.yarovyi.app.cli.menu.handler.MenuHandler;
import com.yarovyi.app.cli.action.operationManagement.OperationRegister;

import java.util.List;

import static com.yarovyi.app.cli.consoleConstant.ConsoleMessageTemplates.*;

public interface Menu {

    boolean isRunning();
    void setRunning(boolean running);
    String getMenuName();
    MenuHandler getMenuHandler();
    OperationRegister getOperationRegister();
    CommandRegister getCommandRegister();
    List<Menu> getSubmenus();
    void addSubmenu(Menu menu);


    default void startMenu() {
        MenuHandler menuHandler = getMenuHandler();

        while (isRunning()) {
            printMenu();
            menuHandler.handleMenu(this);
            PRINT_CONSOLE_SEPARATOR.run();
        }
    }

    default void printMenu() {
        PRINT_MENU_TITLE.accept(getMenuName());
        PRINT_LIST_OF_SUBMENUS.accept(getSubmenus());
        PRINT_LIST_OF_OPERATIONS.accept(getOperationRegister());
        PRINT_LIST_OF_COMMANDS.accept(getCommandRegister());
    }

}
