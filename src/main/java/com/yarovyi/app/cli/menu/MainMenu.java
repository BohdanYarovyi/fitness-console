package com.yarovyi.app.cli.menu;

import com.yarovyi.app.cli.action.commandManagement.command.ExitCommand;

public class MainMenu extends SimpleMenu {

    public MainMenu() {
        super("Lobby");

        addSubmenu(new WorkoutMenu());
        addSubmenu(new StatMenu());
        getCommandRegister().addCommand(new ExitCommand());

        // no one operations
    }
}
