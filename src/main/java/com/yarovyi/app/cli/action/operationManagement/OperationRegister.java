package com.yarovyi.app.cli.action.operationManagement;

import com.yarovyi.app.cli.exception.OperationNotFoundException;
import com.yarovyi.app.cli.action.operationManagement.operation.Operation;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class OperationRegister {
    private final Set<Operation> operations = new HashSet<>();

    public OperationRegister() {}

    public void addOperation(Operation operation) {
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
