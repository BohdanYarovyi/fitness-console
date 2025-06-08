package com.yarovyi.app.ui.cli.action.commandManagement.command;

import com.yarovyi.app.ui.cli.menu.Menu;

import static com.yarovyi.app.ui.cli.view.DefaultViewTemplates.PRINT_MENU_TITLE;
import static com.yarovyi.app.ui.cli.view.DefaultViewTemplates.PRINT_MESSAGE;

/**
 * A standard command for closing the program.
 * <p>
 *     This command provides the {@link #doBeforeExit(Menu, String[])} method.
 *     Override it to perform any necessary logic before exiting.
 * </p>
 *
 * @since 1.0
 * @author Bohdan Yarovyi
 */
public class ExitCommand extends Command {

    /**
     * Executes the exit process from the program.
     * <p>
     *     Currently, it uses {@link System#exit(int)} for immediate termination.
     * </p>
     *
     * @param menu the menu where the command was invoked
     * @param args optional arguments provided by the user, separated by commas
     */
    @Override
    public void execute(Menu menu, String[] args) {
        doBeforeExit(menu, args);

        System.exit(0);
    }

    /**
     * Executes logic before exiting the program.
     * <p>
     *     Override this method in a subclass to perform custom logic before termination,
     *     such as saving data or logging.
     * </p>
     *
     * @param menu the menu where the command was invoked
     * @param args optional arguments provided by the user, separated by commas
     */
    protected void doBeforeExit(Menu menu, String[] args) {
        PRINT_MESSAGE.accept("We are waiting for you to come back ☺️ \uD83D\uDC4B");
    }

    @Override
    public String getPattern() {
        return "/exit";
    }

    @Override
    public String getDescription() {
        return "Urgent exit from the program";
    }

}
