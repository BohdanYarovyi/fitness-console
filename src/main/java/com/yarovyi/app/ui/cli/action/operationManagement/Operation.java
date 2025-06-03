package com.yarovyi.app.ui.cli.action.operationManagement;

import com.yarovyi.app.ui.cli.action.Inputable;
import com.yarovyi.app.ui.cli.context.AppContext;

import java.util.Objects;
import java.util.regex.Pattern;

public abstract class Operation implements Inputable {

    public abstract void doOperation(String[] args);
    public abstract void setApplicationContext(AppContext context);

    public boolean isPatternMatches(String input) {
        return input.matches("^" + Pattern.quote(getPattern()) + "(\\s+.*)?$");
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
