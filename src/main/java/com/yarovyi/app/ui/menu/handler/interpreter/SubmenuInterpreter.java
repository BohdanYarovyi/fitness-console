package com.yarovyi.app.ui.menu.handler.interpreter;

import com.yarovyi.app.ui.menu.Menu;

public class SubmenuInterpreter implements Interpreter {

    @Override
    public boolean canInterpret(String input, Menu menu) {
        int submenusCount = menu.getSubmenus().size();

        try {
            int number = Integer.parseInt(input);

            return number >= 1 && number <= submenusCount;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public void interpret(String input, Menu menu) {
        int number = Integer.parseInt(input);
        Menu submenu = menu.getSubmenus().get(number - 1);

        submenu.setRunning(true);
        submenu.startMenu();
    }

}
