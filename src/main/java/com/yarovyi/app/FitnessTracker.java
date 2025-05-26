package com.yarovyi.app;

import com.yarovyi.app.cli.consoleConstant.ConsoleMessageTemplates;
import com.yarovyi.app.cli.menu.MainMenu;
import com.yarovyi.app.cli.menu.Menu;

public class FitnessTracker {

    public static void main(String[] args) {
        ConsoleMessageTemplates.PRINT_WELCOME.run();

        Menu menu = new MainMenu();
        menu.setRunning(true);
        menu.startMenu();
    }

    /*
        - Maybe need to refactor package hierarchy
     */

}
