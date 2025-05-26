package com.yarovyi.app.cli.action.operationManagement.operation;

import java.util.Objects;

public abstract class Operation {

    public abstract void doOperation();
    public abstract String getOperationDescription();
    public abstract String getOperationPattern();

    public boolean isPatternMatches(String inputPattern) {
        return getOperationPattern().equals(inputPattern);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Operation other)) return false;

        return this.getOperationPattern().equals(other.getOperationPattern());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getOperationPattern());
    }
}
