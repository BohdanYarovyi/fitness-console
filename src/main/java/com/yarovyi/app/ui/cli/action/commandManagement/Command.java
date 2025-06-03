package com.yarovyi.app.ui.cli.action.commandManagement;

import com.yarovyi.app.ui.cli.action.Inputable;
import com.yarovyi.app.ui.cli.menu.Menu;
import com.yarovyi.app.ui.cli.context.AppContext;

import java.util.Objects;
import java.util.regex.Pattern;

public abstract class Command implements Inputable {

    boolean isCommandMatches(String input) {
        return input.matches("^" + Pattern.quote(getPattern()) + "(\\s+.*)?$");
    }

    public abstract void execute(Menu menu, String[] args);
    public abstract void setApplicationContext(AppContext context);

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Command other)) return false;

        return Objects.equals(getPattern(), other.getPattern());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getPattern());
    }

}
