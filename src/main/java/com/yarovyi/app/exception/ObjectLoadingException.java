package com.yarovyi.app.exception;

public class ObjectLoadingException extends Exception {
    public ObjectLoadingException() {
    }

    public ObjectLoadingException(String message) {
        super(message);
    }

    public ObjectLoadingException(String message, Throwable cause) {
        super(message, cause);
    }

    public ObjectLoadingException(Throwable cause) {
        super(cause);
    }

    public ObjectLoadingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
