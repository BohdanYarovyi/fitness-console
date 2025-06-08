package com.yarovyi.app.ui.cli.action.operationManagement;

import com.yarovyi.app.ui.cli.action.commandManagement.command.Command;
import com.yarovyi.app.ui.cli.exception.CommandNotFoundException;
import com.yarovyi.app.ui.cli.exception.OperationNotFoundException;
import com.yarovyi.app.ui.cli.context.AppContext;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Manages operations registered for a specific {@link com.yarovyi.app.ui.cli.menu.Menu menu}.
 * <p>
 *     Each menu can maintain its own set of {@link Operation operations},
 *     allowing for context-specific logic and behaviors.
 * </p>
 *
 * @since 1.0
 * @author Bohdan Yarovyi
 */
public class OperationRegister {
    private final Set<Operation> operations = new HashSet<>();
    private final AppContext context;

    public OperationRegister(AppContext context) {
        this.context = context;
    }

    /**
     * Registers a new {@link Operation operation} and assigns the shared application context to it.
     *
     * @param operation the operation to register
     */
    public void addOperation(Operation operation) {
        operation.setApplicationContext(context);
        this.operations.add(operation);
    }

    /**
     * Checks user input if matches with any having operation.
     *
     * @param userInput the raw user input.
     * @return {@code true} if a matching operation exists; {@code false} otherwise.
     */
    public boolean isRegistered(String userInput) {
        return findOperation(userInput)
                .isPresent();
    }

    /**
     * Retrieves a {@link Operation operation} by pattern from user input.
     *
     * @param userInput the raw user input.
     * @return {@link Operation operation} if it was found by given pattern in user input;
     *          Otherwise throws runtime exception {@link OperationNotFoundException}
     */
    public Operation getOperation(String userInput) {
        return findOperation(userInput)
                .orElseThrow(OperationNotFoundException::new);
    }

    private Optional<Operation> findOperation(String userInput) {
        return operations.stream()
                .filter(o -> o.isPatternMatches(userInput))
                .findFirst();
    }

    public Set<Operation> getOperations() {
        return Collections.unmodifiableSet(operations);
    }

}
