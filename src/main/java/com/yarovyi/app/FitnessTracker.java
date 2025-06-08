package com.yarovyi.app;

import com.yarovyi.app.service.PersistenceService;
import com.yarovyi.app.repository.PersistenceRepository;
import com.yarovyi.app.repository.WorkoutRepository;
import com.yarovyi.app.repository.WorkoutRepositoryImpl;
import com.yarovyi.app.ui.cli.action.commandManagement.CommandRegister;
import com.yarovyi.app.ui.cli.action.commandManagement.command.BackCommand;
import com.yarovyi.app.ui.cli.action.commandManagement.command.ExitCommand;
import com.yarovyi.app.ui.cli.action.operationManagement.OperationRegister;
import com.yarovyi.app.ui.command.AutosaveExitCommand;
import com.yarovyi.app.ui.consoleConstant.ConsoleMessageTemplates;
import com.yarovyi.app.ui.cli.menu.Menu;
import com.yarovyi.app.ui.cli.menu.SimpleMenu;
import com.yarovyi.app.ui.cli.context.AppContext;
import com.yarovyi.app.entity.Workout;
import com.yarovyi.app.repository.persistence.FileServiceImpl;
import com.yarovyi.app.repository.persistence.EntityStorage;
import com.yarovyi.app.repository.persistence.WorkoutJSONFileStorage;
import com.yarovyi.app.ui.menuHandling.SimpleMenuHandler;
import com.yarovyi.app.ui.operation.*;

import java.io.File;

public class FitnessTracker {
    public static final String WORKOUTS_FILE_PATH = "workouts.json";

    public static void main(String[] args) {
        // context
        AppContext context = configureContext();

        // load persistence entities
        PersistenceService persistenceService = context.getComponent("persistenceService", PersistenceService.class);
        persistenceService.loadAll();

        // run
        configureAndRun(context);
    }

    public static void configureAndRun(AppContext context) {
        ConsoleMessageTemplates.PRINT_WELCOME.run();

        Menu menu = createLobbyMenu(context);
        menu.setRunning(true);
        menu.startMenu();
    }

    public static Menu createLobbyMenu(AppContext context) {
        Menu lobby = new SimpleMenu("Lobby", new SimpleMenuHandler(), context);

        // add submenus
        Menu statMenu = createStatMenu(context);
        Menu workoutMenu = createWorkoutMenu(context);
        lobby.addSubmenu(statMenu);
        lobby.addSubmenu(workoutMenu);

        // add command in register
        lobby.getCommandRegister().addCommand(new AutosaveExitCommand());

        return lobby;
    }

    public static Menu createStatMenu(AppContext context) {
        Menu stat = new SimpleMenu("Statistics", new SimpleMenuHandler(), context);

        // add commands in register
        CommandRegister commandRegister = stat.getCommandRegister();
        commandRegister.addCommand(new AutosaveExitCommand());
        commandRegister.addCommand(new BackCommand());

        // add operations in register
        OperationRegister operationRegister = stat.getOperationRegister();
        operationRegister.addOperation(new CountCaloriesForWeekOperation());
        operationRegister.addOperation(new CountCaloriesForMonthOperation());

        return stat;
    }

    public static Menu createWorkoutMenu(AppContext context) {
        Menu workoutMenu = new SimpleMenu("Workout management", new SimpleMenuHandler(), context);

        // add commands in register
        CommandRegister commandRegister = workoutMenu.getCommandRegister();
        commandRegister.addCommand(new AutosaveExitCommand());
        commandRegister.addCommand(new BackCommand());

        // add operations in register
        OperationRegister operationRegister = workoutMenu.getOperationRegister();
        operationRegister.addOperation(new AddWorkoutOperation());
        operationRegister.addOperation(new ShowAllWorkoutsOperation());
        operationRegister.addOperation(new DeleteWorkoutOperation());

        return workoutMenu;
    }

    public static AppContext configureContext() {
        // WORKOUT repository
        WorkoutRepository workoutRepository = getWorkoutRepository(WORKOUTS_FILE_PATH);

        // PERSISTENCE service
        PersistenceService persistenceService = new PersistenceService();
        persistenceService.addPersistenceRepository((PersistenceRepository) workoutRepository);

        AppContext context = new AppContext();
        context.addComponent("persistenceService", persistenceService);
        context.addComponent("workoutRepository", workoutRepository);

        return context;
    }

    public static WorkoutRepository getWorkoutRepository(String workoutFilePath) {
        FileServiceImpl fileService = new FileServiceImpl();
        File file = new File(workoutFilePath);
        EntityStorage<Workout> workoutEntityStorage = new WorkoutJSONFileStorage(fileService, file);

        return new WorkoutRepositoryImpl(workoutEntityStorage);
    }

}
