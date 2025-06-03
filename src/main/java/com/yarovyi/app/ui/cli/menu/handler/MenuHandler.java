package com.yarovyi.app.ui.cli.menu.handler;

import com.yarovyi.app.ui.cli.menu.Menu;
import com.yarovyi.app.ui.cli.menu.handler.inputInterpreter.CommandInterpreter;
import com.yarovyi.app.ui.cli.menu.handler.inputInterpreter.Interpreter;
import com.yarovyi.app.ui.cli.menu.handler.inputInterpreter.OperationInterpreter;
import com.yarovyi.app.ui.cli.menu.handler.inputInterpreter.SubmenuInterpreter;

import java.util.ArrayList;
import java.util.List;

public abstract class MenuHandler {
    private final List<Interpreter> interpreters;

    public MenuHandler() {
        this.interpreters = new ArrayList<>();

        this.interpreters.add(new CommandInterpreter());
        this.interpreters.add(new OperationInterpreter());
        this.interpreters.add(new SubmenuInterpreter());
    }

    public MenuHandler(List<Interpreter> interpreters) {
        this.interpreters = interpreters;
    }

    public void addInterpreter(Interpreter interpreter) {
        interpreters.add(interpreter);
    }

    protected List<Interpreter> getInterpreters() {
        return this.interpreters;
    }

    public void handleMenu(Menu menu) {
        String userInput = getUserInput();

        List<Interpreter> interpreters = getInterpreters();
        for (Interpreter interpreter : interpreters) {
            if (interpreter.canInterpret(userInput, menu)) {
                interpreter.interpret(userInput, menu);
                return;
            }
        }

        System.out.println("Input not valid: " + userInput);
    }

    protected abstract String getUserInput();

}
