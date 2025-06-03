package com.yarovyi.app.ui.command;

import com.yarovyi.app.service.PersistenceService;
import com.yarovyi.app.ui.cli.action.commandManagement.Command;
import com.yarovyi.app.ui.cli.menu.Menu;
import com.yarovyi.app.ui.cli.context.AppContext;

import java.util.Arrays;

import static com.yarovyi.app.ui.consoleConstant.ConsoleMessageTemplates.PRINT_MESSAGE;

public class ExitCommand extends Command {
    private AppContext appContext;

    @Override
    public void execute(Menu menu, String[] args) {
        PersistenceService persistenceService = appContext.getComponent("persistenceService", PersistenceService.class);
        persistenceService.saveAll();

        PRINT_MESSAGE.accept("We are waiting for you to come back ☺️ \uD83D\uDC4B");
        System.exit(0);
    }

    @Override
    public String getPattern() {
        return "/exit";
    }

    @Override
    public String getDescription() {
        return "Urgent exit from the program";
    }

    @Override
    public void setApplicationContext(AppContext context) {
        this.appContext = context;
    }

}
