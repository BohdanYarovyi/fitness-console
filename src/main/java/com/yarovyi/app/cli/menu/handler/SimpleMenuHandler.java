package com.yarovyi.app.cli.menu.handler;

import com.yarovyi.app.cli.menu.handler.interpreter.CommandInterpreter;
import com.yarovyi.app.cli.menu.handler.interpreter.Interpreter;
import com.yarovyi.app.cli.menu.handler.interpreter.OperationInterpreter;
import com.yarovyi.app.cli.menu.handler.interpreter.SubmenuInterpreter;
import com.yarovyi.app.cli.util.Console;

import java.util.ArrayList;
import java.util.List;

public class SimpleMenuHandler implements MenuHandler {
    private final List<Interpreter> interpreters;

    public SimpleMenuHandler() {
        this.interpreters = new ArrayList<>();

        this.interpreters.add(new CommandInterpreter());
        this.interpreters.add(new OperationInterpreter());
        this.interpreters.add(new SubmenuInterpreter());
    }

    @Override
    public String getUserInput() {
        return Console.getUserInput();
    }

    @Override
    public List<Interpreter> getInterpreters() {
        return this.interpreters;
    }

}
