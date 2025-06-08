package com.yarovyi.app.ui.cli.action;

import com.yarovyi.app.ui.cli.action.commandManagement.command.Command;

/**
 * Defines components that represent either a command or an operation.
 * <p>
 *     These elements can provide a description of what they do, and a pattern
 *     that the program uses to recognize them based on user input.
 * </p>
 *
 * @see com.yarovyi.app.ui.cli.action.operationManagement.Operation Operation
 * @see Command Command
 * @since 1.0
 * @author Bohdan Yarovyi
 */
public interface Inputable {

    /**
     * Returns the input pattern of command or operation.
     * <p>
     *     Pattern defines what user should enter to execute command.
     * </p>
     * <p>
     *      <b>Example:</b>
     *      <pre>
     *           {@code
     *               @Override
     *               public String getPattern() {
     *                   return "/back";
     *               }
     *           }
     *      </pre>
     *      <b>User should enter, to execute this command:</b>
     *      <pre>
     *          {@code
     *              /back
     *          }
     *      </pre>
     * </p>
     */
    String getPattern();

    /**
     * Returns a human-readable description of the command or operation.
     * <p>
     *     It may use in help-block or UI-displays etc.
     * </p>
     * @return description of command or operation
     */
    String getDescription();

}
