package com.yarovyi.app.cli.action.commandManagement.command;

import com.yarovyi.app.cli.menu.Menu;
import com.yarovyi.app.context.AppContext;

public interface Command {

    void execute(Menu menu);
    String getCommandPattern();
    String getCommandDescription();
    void setApplicationContext(AppContext context);

    default boolean isCommandMatches(String consoleInput) {
        return getCommandPattern().equals(consoleInput);
    }

}
