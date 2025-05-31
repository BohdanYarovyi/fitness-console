package com.yarovyi.app.ui.action.commandManagement.command;

import com.yarovyi.app.ui.menu.Menu;
import com.yarovyi.app.context.AppContext;
import com.yarovyi.app.entity.Workout;
import com.yarovyi.app.exception.ObjectSavingException;
import com.yarovyi.app.repository.WorkoutRepository;
import com.yarovyi.app.repository.persistence.EntityStorage;

import java.util.List;

import static com.yarovyi.app.ui.consoleConstant.ConsoleMessageTemplates.PRINT_ERROR;
import static com.yarovyi.app.ui.consoleConstant.ConsoleMessageTemplates.PRINT_MESSAGE;

public class ExitCommand implements Command {
    private AppContext appContext;

    @Override
    public void execute(Menu menu) {
        appContext.getPersistenceService().saveAll();
        PRINT_MESSAGE.accept("We are waiting for you to come back ☺️ \uD83D\uDC4B");
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
