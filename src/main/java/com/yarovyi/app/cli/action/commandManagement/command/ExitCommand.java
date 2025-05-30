package com.yarovyi.app.cli.action.commandManagement.command;

import com.yarovyi.app.cli.menu.Menu;
import com.yarovyi.app.context.AppContext;

public class ExitCommand implements Command {
    private AppContext appContext;

    @Override
    public void execute(Menu menu) {
        System.out.println("We are waiting for you to come back ☺️ \uD83D\uDC4B");
        System.exit(0);
    }

    @Override
    public String getCommandPattern() {
        return "/exit";
    }

    @Override
    public String getCommandDescription() {
        return "Urgent exit from the program";
    }

    @Override
    public void setApplicationContext(AppContext context) {
        this.appContext = context;
    }

}
