package com.yarovyi.app.ui.cli.exception;

/**
 * Thrown when a requested operation is not found.
 * <p>
 *     When {@link com.yarovyi.app.ui.cli.action.operationManagement.OperationRegister OperationRegister}
 *     try to find specific operation using pattern from user input, and if not found such operation,
 *     throws this exception.
 * </p>
 *
 * @see com.yarovyi.app.ui.cli.action.operationManagement.OperationRegister OperationRegister
 * @since 1.0
 * @author Bohnda Yarovyi
 */
public class OperationNotFoundException extends RuntimeException {

    public OperationNotFoundException() {
    }

    public OperationNotFoundException(String message) {
        super(message);
    }

    public OperationNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public OperationNotFoundException(Throwable cause) {
        super(cause);
    }

    public OperationNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
