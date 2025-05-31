package com.yarovyi.app.ui.action.commandManagement.command;

import com.yarovyi.app.ui.menu.Menu;
import com.yarovyi.app.context.AppContext;

public class BackCommand implements Command {
    private AppContext appContext;

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

    @Override
    public void setApplicationContext(AppContext context) {
        this.appContext = context;
    }

}
