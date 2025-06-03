package com.yarovyi.app.exception;

public class UserInputNotValidException extends Exception {

    public UserInputNotValidException() {
    }

    public UserInputNotValidException(String message) {
        super(message);
    }

    public UserInputNotValidException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserInputNotValidException(Throwable cause) {
        super(cause);
    }

    public UserInputNotValidException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
