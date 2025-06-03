package com.yarovyi.app.ui.command;

import com.yarovyi.app.ui.cli.action.commandManagement.Command;
import com.yarovyi.app.ui.cli.menu.Menu;
import com.yarovyi.app.ui.cli.context.AppContext;

import java.util.Arrays;

public class BackCommand extends Command {
    private AppContext appContext;

    @Override
    public void execute(Menu menu, String[] args) {
        menu.setRunning(false);
        System.out.println("Leaved from " + menu.getMenuName());
    }

    @Override
    public String getPattern() {
        return "/back";
    }

    @Override
    public String getDescription() {
        return "Back to previous menu";
    }

    @Override
    public void setApplicationContext(AppContext context) {
        this.appContext = context;
    }

}
