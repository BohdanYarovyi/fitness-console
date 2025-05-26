package com.yarovyi.app.cli.action.commandManagement.command;

import com.yarovyi.app.cli.menu.Menu;

public class BackCommand implements Command {

    @Override
    public void execute(Menu menu) {
        menu.setRunning(false);
        System.out.println("Leaved from " + menu.getMenuName());
    }

    @Override
    public String getCommandPattern() {
        return "/back";
    }

    @Override
    public String getCommandDescription() {
        return "Back to previous menu";
    }

}
