package com.yarovyi.app.ui.cli.exception;

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
