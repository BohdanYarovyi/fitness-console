package com.yarovyi.app.ui.cli.exception;

/**
 * Thrown when a requested command is not found.
 * <p>
 *     When {@link com.yarovyi.app.ui.cli.action.commandManagement.CommandRegister CommandRegister}
 *     try to find specific command using pattern from user input, and if not found such command,
 *     throws this exception.
 * </p>
 *
 * @see com.yarovyi.app.ui.cli.action.commandManagement.CommandRegister CommandRegister
 * @since 1.0
 * @author Bohnda Yarovyi
 */
public class CommandNotFoundException extends RuntimeException {

    public CommandNotFoundException() {}

    public CommandNotFoundException(String message) {
        super(message);
    }

    public CommandNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommandNotFoundException(Throwable cause) {
        super(cause);
    }

    public CommandNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
