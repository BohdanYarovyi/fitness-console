package com.yarovyi.app.ui.command;

import com.yarovyi.app.service.PersistenceService;
import com.yarovyi.app.ui.cli.action.commandManagement.command.ExitCommand;
import com.yarovyi.app.ui.cli.menu.Menu;

public class AutosaveExitCommand extends ExitCommand {

    @Override
    protected void doBeforeExit(Menu menu, String[] args) {
        super.doBeforeExit(menu, args);

        // saving entities
        var context = getApplicationContext();
        var persistenceService = context.getComponent("persistenceService", PersistenceService.class);
        persistenceService.saveAll();
    }

}
