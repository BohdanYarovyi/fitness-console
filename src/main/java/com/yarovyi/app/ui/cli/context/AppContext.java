package com.yarovyi.app.ui.cli.context;

import com.yarovyi.app.ui.cli.exception.ContextNotFoundComponentException;

import java.util.HashMap;
import java.util.Map;
import java.util.MissingFormatArgumentException;

public class AppContext {
    private final Map<String, Object> components = new HashMap<>();

    public AppContext() {}

    public void addComponent(String name, Object component) {
        this.components.put(name, component);
    }

    public <T> T getComponent(String name, Class<T> type) {
        Object result = components.get(name);

        if (result == null) {
            throw new ContextNotFoundComponentException("Not found component with name " + name + " in context");
        }

        return type.cast(result);
    }

    public boolean containsComponent(String name) {
        return components.containsKey(name);
    }

}
