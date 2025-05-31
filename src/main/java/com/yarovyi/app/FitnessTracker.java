package com.yarovyi.app;

import com.yarovyi.app.context.PersistenceService;
import com.yarovyi.app.repository.PersistenceRepository;
import com.yarovyi.app.repository.WorkoutRepository;
import com.yarovyi.app.repository.WorkoutRepositoryImpl;
import com.yarovyi.app.ui.action.commandManagement.CommandRegister;
import com.yarovyi.app.ui.action.commandManagement.command.BackCommand;
import com.yarovyi.app.ui.action.commandManagement.command.ExitCommand;
import com.yarovyi.app.ui.action.operationManagement.OperationRegister;
import com.yarovyi.app.ui.action.operationManagement.operation.*;
import com.yarovyi.app.ui.consoleConstant.ConsoleMessageTemplates;
import com.yarovyi.app.ui.menu.*;
import com.yarovyi.app.context.AppContext;
import com.yarovyi.app.entity.Workout;
import com.yarovyi.app.repository.persistence.FileServiceImpl;
import com.yarovyi.app.repository.persistence.EntityStorage;
import com.yarovyi.app.repository.persistence.WorkoutJSONFileStorage;

public class FitnessTracker {

    public static void main(String[] args) {
        WorkoutRepository workoutRepository = getWorkoutRepository();

        PersistenceService persistenceService = new PersistenceService();
        persistenceService.addPersistenceRepository((PersistenceRepository) workoutRepository);

        AppContext context = new AppContext(persistenceService, workoutRepository);
        persistenceService.loadAll();

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

    public static WorkoutRepository getWorkoutRepository() {
        FileServiceImpl fileService = new FileServiceImpl();
        EntityStorage<Workout> workoutEntityStorage = new WorkoutJSONFileStorage(fileService);

        return new WorkoutRepositoryImpl(workoutEntityStorage);
    }

}
