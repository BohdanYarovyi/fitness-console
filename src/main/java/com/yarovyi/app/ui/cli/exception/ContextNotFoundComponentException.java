package com.yarovyi.app.ui.cli.exception;

/**
 * Throws if not found requested component.
 *
 * @see com.yarovyi.app.ui.cli.context.AppContext AppContext
 * @author Bohdan Yarovyi
 * @since 1.0
 */
public class ContextNotFoundComponentException extends RuntimeException {

    public ContextNotFoundComponentException() {
    }

    public ContextNotFoundComponentException(String message) {
        super(message);
    }

    public ContextNotFoundComponentException(String message, Throwable cause) {
        super(message, cause);
    }

    public ContextNotFoundComponentException(Throwable cause) {
        super(cause);
    }

    public ContextNotFoundComponentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
