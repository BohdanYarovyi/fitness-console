package com.yarovyi.app.ui.cli.action.commandManagement.command;

import com.yarovyi.app.ui.cli.menu.Menu;
import com.yarovyi.app.ui.cli.context.AppContext;

/**
 * A standard command that navigates back to the previous menu.
 * <p>
 *     Not recommended to add this command at the first menu.Typically used to exit from the current menu
 *     and return to the previous one in the menu stack.
 * </p>
 * <p>
 *     <b>Note:</b> Not recommended to use this command in the root or main menu,
 *     as there may be nowhere to return.
 * </p>
 *
 * @since 1.0
 * @author Bohdan Yarovyi
 */
public class BackCommand extends Command {

    /**
     * Executes the back navigation command.
     * <p>
     *     It sets the current menu's {@code running} flag to {@code false},
     *     which indicates that the menu should close.
     * </p>
     *
     * @param menu the menu where the command was invoked
     * @param args optional arguments provided by the user (ignored in this command)
     */
    @Override
    public void execute(Menu menu, String[] args) {
        menu.setRunning(false);
        System.out.println("Leaved from " + menu.getMenuName());
    }

    @Override
    public String getPattern() {
        return "/back";
    }

    @Override
    public String getDescription() {
        return "Back to previous menu";
    }

}
