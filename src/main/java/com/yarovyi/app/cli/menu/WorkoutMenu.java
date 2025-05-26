package com.yarovyi.app.cli.menu;

import com.yarovyi.app.cli.action.commandManagement.CommandRegister;
import com.yarovyi.app.cli.action.commandManagement.command.BackCommand;
import com.yarovyi.app.cli.action.commandManagement.command.ExitCommand;
import com.yarovyi.app.cli.action.operationManagement.OperationRegister;
import com.yarovyi.app.cli.action.operationManagement.operation.AddWorkoutOperation;
import com.yarovyi.app.cli.action.operationManagement.operation.DeleteWorkoutOperation;
import com.yarovyi.app.cli.action.operationManagement.operation.ShowAllWorkoutsOperation;

public class WorkoutMenu extends SimpleMenu {

    public WorkoutMenu() {
        super("WorkoutMenu management");

        // here maybe some menus

        CommandRegister commandRegister = getCommandRegister();
        commandRegister.addCommand(new ExitCommand());
        commandRegister.addCommand(new BackCommand());

        OperationRegister operationRegister = getOperationRegister();
        operationRegister.addOperation(new AddWorkoutOperation());
        operationRegister.addOperation(new ShowAllWorkoutsOperation());
        operationRegister.addOperation(new DeleteWorkoutOperation());
    }

}
