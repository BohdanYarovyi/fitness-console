package com.yarovyi.app.ui.command;

import com.yarovyi.app.service.PersistenceService;
import io.github.bohdanyarovyi.cli.action.commandManagement.command.ExitCommand;
import io.github.bohdanyarovyi.cli.menu.Menu;

public class AutosaveExitCommand extends ExitCommand {

    @Override
    protected void doBeforeExit(Menu menu, String[] args) {
        super.doBeforeExit(menu, args);

        // saving entities
        var context = getAppContext();
        var persistenceService = context.getComponent("persistenceService", PersistenceService.class);
        persistenceService.saveAll();
    }

}
