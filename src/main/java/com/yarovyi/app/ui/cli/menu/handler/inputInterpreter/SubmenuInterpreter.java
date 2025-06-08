package com.yarovyi.app.ui.cli.menu.handler.inputInterpreter;

import com.yarovyi.app.ui.cli.menu.Menu;

/**
 * A default interpreter for selecting submenus by entering a number.
 * <p>
 *     This interpreter checks if the user input is a valid number
 *     that corresponds to an available submenu in the current menu.
 *     If valid, it launches the selected submenu.
 * </p>
 *
 * @see Menu
 * @see Interpreter
 * @since 1.0
 * @author Bohdan Yarovyi
 */
public class SubmenuInterpreter implements Interpreter {

    /**
     * Checks whether the user input corresponds to a valid submenu index.
     * <p>
     *     Interprets the input as a number and verifies that it is within the range
     *     of available submenus in the current {@link Menu}.
     * </p>
     *
     * @return {@code true} if the input is a number within the range of submenu options;
     *         {@code false} otherwise
     */
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

    /**
     * Launches the submenu corresponding to the given number.
     * <p>
     *     Starts the submenu by setting it as running and invoking its {@link Menu#startMenu()} method.
     *     Assumes the input is already validated by {@link #canInterpret(String, Menu)}.
     * </p>
     *
     */
    @Override
    public void interpret(String input, Menu menu) {
        int number = Integer.parseInt(input);
        Menu submenu = menu.getSubmenus().get(number - 1);

        submenu.setRunning(true);
        submenu.startMenu();
    }

}
