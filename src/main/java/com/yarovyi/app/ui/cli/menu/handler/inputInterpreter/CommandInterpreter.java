package com.yarovyi.app.ui.cli.menu.handler.inputInterpreter;

import com.yarovyi.app.ui.cli.action.Inputable;
import com.yarovyi.app.ui.cli.action.commandManagement.command.Command;
import com.yarovyi.app.ui.cli.action.commandManagement.CommandRegister;
import com.yarovyi.app.ui.cli.menu.Menu;
import com.yarovyi.app.ui.cli.menu.handler.MenuHandler;

/**
 * A default interpreter for simple commands like "/exit" or "/back".
 *
 * <p>
 *     This implementation checks whether the input matches a known {@link Command},
 *     and if so — executes it using the {@link CommandRegister}.
 * </p>
 *
 *  <p>
 *      This interpreter is intended to be placed first in the interpreter chain
 *      to give priority to global commands like exiting or navigating back.
 *  </p>
 *
 * @author Bohdan Yarovyi
 * @since 1.0
 * @see MenuHandler
 * @see Interpreter
 * @see Command
 */
public class CommandInterpreter implements Interpreter {

    /**
     * Checks whether the user input matches a registered command in the current menu.
     * <p>
     *     Uses {@link CommandRegister} from the given {@link Menu} to verify
     *     if the input corresponds to a known command (e.g., "/exit", "/help").
     * </p>
     * @return {@code true} if the input is a valid command; {@code false} otherwise.
     */
    @Override
    public boolean canInterpret(String input, Menu menu) {
        return menu.getCommandRegister().isCommand(input);
    }

    /**
     * Execute command by user input.
     * <p>
     *      Determines using {@link CommandRegister} from {@link Menu} and calls the desired command
     *      by passing arguments from user input parsed by {@link #getArgs(Inputable, String)}.
     * </p>
     */
    @Override
    public void interpret(String input, Menu menu) {
        CommandRegister commandRegister = menu.getCommandRegister();
        Command command = commandRegister.getCommand(input);

        String[] args = getArgs(command, input);
        command.execute(menu, args);
    }

}
