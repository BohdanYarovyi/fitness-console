package com.yarovyi.app.cli.menu;

import com.yarovyi.app.cli.action.commandManagement.CommandRegister;
import com.yarovyi.app.cli.action.commandManagement.command.BackCommand;
import com.yarovyi.app.cli.action.commandManagement.command.ExitCommand;
import com.yarovyi.app.cli.action.operationManagement.OperationRegister;
import com.yarovyi.app.cli.action.operationManagement.operation.CountCaloriesForMonthOperation;
import com.yarovyi.app.cli.action.operationManagement.operation.CountCaloriesForWeekOperation;

public class StatMenu extends SimpleMenu {

    public StatMenu() {
        super("Statistics");

        // no one submenu
        CommandRegister commandRegister = getCommandRegister();
        commandRegister.addCommand(new ExitCommand());
        commandRegister.addCommand(new BackCommand());

        OperationRegister operationRegister = getOperationRegister();
        operationRegister.addOperation(new CountCaloriesForWeekOperation());
        operationRegister.addOperation(new CountCaloriesForMonthOperation());
    }

}
