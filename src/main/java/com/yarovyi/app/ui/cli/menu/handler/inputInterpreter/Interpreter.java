package com.yarovyi.app.ui.cli.menu.handler.inputInterpreter;

import com.yarovyi.app.ui.cli.action.Inputable;
import com.yarovyi.app.ui.cli.menu.Menu;

/**
 * Represents a strategy for interpreting user input in the context of a CLI menu.
 * <p>
 *     Implementation of this interface define how specific types of input
 *     are recognized and handled (commands, operation, submenu selections etc.).
 *     This enables the application to decouple parsing logic from input handling logic.
 * </p>
 * <p>
 *     If you introduce a new type of input (e.g., a new syntax or command),
 *     create a corresponding {@link Interpreter} that defines how to recognize and process that input.
 * </p>
 * <p>
 *     Default interpreter implementations:
 *     <ul>
 *         <li>{@link CommandInterpreter} — interprets predefined commands (e.g. /exit)</li>
 *         <li>{@link OperationInterpreter} — interprets domain-specific operations (e.g. /addWorkout)</li>
 *         <li>{@link SubmenuInterpreter} — interprets numeric selections for submenu navigation</li>
 *     </ul>
 * </p>
 *
 * @author Bohdan Yarovyi
 * @since 1.0
 * @see CommandInterpreter
 * @see OperationInterpreter
 * @see SubmenuInterpreter
 */
public interface Interpreter {

    /**
     *  Determines whether this interpreter can handle the given user input
     *  in the context of the specified menu.
     *
     * @param input the raw user input.
     * @param menu where user has entered an input.
     * @return {@code true} if user input is recognized by any interpreter;
     *          {@code false} otherwise.
     */
    boolean canInterpret(String input, Menu menu);

    /**
     * Processes the given user input within the specified menu.
     * <p>
     *     This method is called only if {@link #canInterpret(String, Menu)} returned {@code true}.
     *     The implementation defines how to execute the logic corresponding to the recognized input.
     * </p>
     *
     * @param input the raw user input.
     * @param menu where user has entered an input.
     */
    void interpret(String input, Menu menu);

    /**
     * Extracts arguments from the user input by removing the command pattern prefix.
     * <p>
     *     This method assumes that the input starts with a known command or operation pattern,
     *     followed by arguments separated by spaces.
     * </p>
     * <p><strong>Example:</strong></p>
     * <pre>
     *     {@code
     *         Inputable pattern: "/add"
     *         User input: "/add Monday LegDay"
     *         Result: ["Monday", "LegDay"]
     *     }
     * </pre>
     *
     * @param inputable the command or operation that provides the pattern
     * @param input the raw user input.
     * @return an array of arguments (excluding the command pattern), split by space
     */
    default String[] getArgs(Inputable inputable, String input) {
        String withoutPattern = input.replace(inputable.getPattern() + " ", "");

        return withoutPattern.split(" ");
    }

}
