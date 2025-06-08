package com.yarovyi.app.ui.cli.action.operationManagement;

import com.yarovyi.app.ui.cli.action.Inputable;
import com.yarovyi.app.ui.cli.context.AppContext;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Abstract class for custom business-based operation.
 * <p>
 *     Intended for custom business operation like ({@code /countSum},
 *     {@code /printList}, {@code /createUser}, etc).
 * </p>
 * <p>
 *     {@link OperationRegister} manage operations, so to add new operation,
 *     you should register it in the {@link OperationRegister operation register} of the specific menu.
 * </p>
 *
 * @since 1.0
 * @author Bohdan Yarovyi
 */
public abstract class Operation implements Inputable {
    /**
     * Application context for component access possibility.
     */
    private AppContext appContext;

    /**
     * Executes the core logic of the operation.
     * <p>
     *     Contains the business logic specific to this operation.
     * </p>
     *
     * @param args optional arguments of operation
     */
    public abstract void doOperation(String[] args);

    /**
     * Checks if the user input matches with operation pattern.
     * Useful for determining whether the user intended to call this operation,
     * even if arguments are also present.
     *
     * @param input raw user input
     * @return {@code true} if the pattern matches; {@code false} otherwise.
     */
    public boolean isPatternMatches(String input) {
        return input.matches("^" + Pattern.quote(getPattern()) + "(\\s+.*)?$");
    }

    public void setApplicationContext(AppContext context) {
        this.appContext = context;
    }
    public AppContext getApplicationContext() {
        return this.appContext;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Operation other)) return false;

        return this.getPattern().equals(other.getPattern());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getPattern());
    }
}
