package com.yarovyi.app.cli.action.commandManagement.command;

import com.yarovyi.app.cli.menu.Menu;

public interface Command {

    void execute(Menu menu);
    String getCommandPattern();
    String getCommandDescription();

    default boolean isCommandMatches(String consoleInput) {
        return getCommandPattern().equals(consoleInput);
    }

}
