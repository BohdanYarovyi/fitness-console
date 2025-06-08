package com.yarovyi.app.ui.cli.menu.handler;

import com.yarovyi.app.ui.cli.menu.Menu;
import com.yarovyi.app.ui.cli.menu.handler.inputInterpreter.CommandInterpreter;
import com.yarovyi.app.ui.cli.menu.handler.inputInterpreter.Interpreter;
import com.yarovyi.app.ui.cli.menu.handler.inputInterpreter.OperationInterpreter;
import com.yarovyi.app.ui.cli.menu.handler.inputInterpreter.SubmenuInterpreter;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract base class for handling user interaction in a CLI menu.
 * <p>
 *     A {@code MenuHandler} maintains a list of input interpreters.
 *     These interpreters are responsible for recognizing user input and executing
 *     the corresponding command, operation, or submenu selection.
 * </p>
 * <p>
 *     The default constructor registers three interpreters by default:
 *     <ul>
 *         <li>{@link CommandInterpreter}</li>
 *         <li>{@link OperationInterpreter}</li>
 *         <li>{@link SubmenuInterpreter}</li>
 *     </ul>
 * </p>
 *
 * @author Bohdan Yarovyi
 * @since 1.0
 * @see Interpreter
 */
public abstract class MenuHandler {

    /**
     * List of interpreters.
     */
    private final List<Interpreter> interpreters;

    /**
     * Initializes the handler with default set of interpreters:
     * command, operation, and submenu interpreters.
     *
     *
     */
    public MenuHandler() {
        this.interpreters = new ArrayList<>();

        this.interpreters.add(new CommandInterpreter());
        this.interpreters.add(new OperationInterpreter());
        this.interpreters.add(new SubmenuInterpreter());
    }

    /**
     * Initializes the handler with custom interpreters.
     * @param interpreters custom list of interpreters.
     */
    public MenuHandler(List<Interpreter> interpreters) {
        this.interpreters = interpreters;
    }

    /**
     * Adds a new interpreter to list.
     * @param interpreter some other implementation of interpreter
     */
    public void addInterpreter(Interpreter interpreter) {
        interpreters.add(interpreter);
    }

    protected List<Interpreter> getInterpreters() {
        return this.interpreters;
    }

    /**
     * Handles menu.
     * <p>
     *     Gets user input using {@link #getUserInput()} and search for matching options that this menu is providing.
     *     Each interpreter can recognize own command by pattern, and if user input is matches,
     *     interpreter run desired command.
     * </p>
     * <p>
     *     If not found any matches, prints message in the console.
     * </p>
     * @param menu which this handler is handling
     */
    public void handleMenu(Menu menu) {
        String userInput = getUserInput();

        List<Interpreter> interpreters = getInterpreters();
        for (Interpreter interpreter : interpreters) {
            if (interpreter.canInterpret(userInput, menu)) {
                interpreter.interpret(userInput, menu);
                return;
            }
        }

        System.out.println("Input not valid: " + userInput);
    }

    /**
     * To create own MenuHandler, implement this method that should return userInput.
     * @return user input like {@link String}
     */
    protected abstract String getUserInput();

}
