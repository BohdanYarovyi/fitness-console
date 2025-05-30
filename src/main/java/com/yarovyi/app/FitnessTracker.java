package com.yarovyi.app;

import com.yarovyi.app.cli.action.commandManagement.CommandRegister;
import com.yarovyi.app.cli.action.commandManagement.command.BackCommand;
import com.yarovyi.app.cli.action.commandManagement.command.ExitCommand;
import com.yarovyi.app.cli.action.operationManagement.OperationRegister;
import com.yarovyi.app.cli.action.operationManagement.operation.*;
import com.yarovyi.app.cli.consoleConstant.ConsoleMessageTemplates;
import com.yarovyi.app.cli.menu.*;
import com.yarovyi.app.context.AppContext;
import com.yarovyi.app.repository.WorkoutRepositoryImpl;

public class FitnessTracker {

    public static void main(String[] args) {
        AppContext context = new AppContext(new WorkoutRepositoryImpl());

        runCli(context);
    }

    public static void runCli(AppContext context) {
        ConsoleMessageTemplates.PRINT_WELCOME.run();

        Menu menu = createLobbyMenu(context);
        menu.setRunning(true);
        menu.startMenu();
    }

    public static Menu createLobbyMenu(AppContext context) {
        Menu lobby = new SimpleMenu("Lobby", context);

        // add submenus
        Menu statMenu = createStatMenu(context);
        Menu workoutMenu = createWorkoutMenu(context);
        lobby.addSubmenu(statMenu);
        lobby.addSubmenu(workoutMenu);

        // add command in register
        lobby.getCommandRegister().addCommand(new ExitCommand());

        return lobby;
    }

    public static Menu createStatMenu(AppContext context) {
        Menu stat = new SimpleMenu("Statistics", context);

        // add commands in register
        CommandRegister commandRegister = stat.getCommandRegister();
        commandRegister.addCommand(new ExitCommand());
        commandRegister.addCommand(new BackCommand());

        // add operations in register
        OperationRegister operationRegister = stat.getOperationRegister();
        operationRegister.addOperation(new CountCaloriesForWeekOperation());
        operationRegister.addOperation(new CountCaloriesForMonthOperation());

        return stat;
    }

    public static Menu createWorkoutMenu(AppContext context) {
        Menu workoutMenu = new SimpleMenu("Workout management", context);

        // add commands in register
        CommandRegister commandRegister = workoutMenu.getCommandRegister();
        commandRegister.addCommand(new ExitCommand());
        commandRegister.addCommand(new BackCommand());

        // add operations in register
        OperationRegister operationRegister = workoutMenu.getOperationRegister();
        operationRegister.addOperation(new AddWorkoutOperation());
        operationRegister.addOperation(new ShowAllWorkoutsOperation());
        operationRegister.addOperation(new DeleteWorkoutOperation());

        return workoutMenu;
    }

}
