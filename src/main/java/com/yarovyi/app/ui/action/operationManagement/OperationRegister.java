package com.yarovyi.app.ui.action.operationManagement;

import com.yarovyi.app.ui.exception.OperationNotFoundException;
import com.yarovyi.app.ui.action.operationManagement.operation.Operation;
import com.yarovyi.app.context.AppContext;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class OperationRegister {
    private final Set<Operation> operations = new HashSet<>();
    private final AppContext context;

    public OperationRegister(AppContext context) {
        this.context = context;
    }

    public void addOperation(Operation operation) {
        operation.setApplicationContext(context);
        this.operations.add(operation);
    }

    public Operation getOperation(String userInput) {
        return findOperation(userInput)
                .orElseThrow(OperationNotFoundException::new);
    }

    public boolean isRegistered(String userInput) {
        return findOperation(userInput)
                .isPresent();
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
