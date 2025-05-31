package com.yarovyi.app.exception;

public class ObjectSavingException extends Exception {
    public ObjectSavingException() {
    }

    public ObjectSavingException(String message) {
        super(message);
    }

    public ObjectSavingException(String message, Throwable cause) {
        super(message, cause);
    }

    public ObjectSavingException(Throwable cause) {
        super(cause);
    }

    public ObjectSavingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
