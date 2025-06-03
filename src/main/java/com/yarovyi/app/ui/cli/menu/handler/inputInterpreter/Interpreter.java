package com.yarovyi.app.ui.cli.menu.handler.inputInterpreter;

import com.yarovyi.app.ui.cli.action.Inputable;
import com.yarovyi.app.ui.cli.menu.Menu;

public interface Interpreter {

    boolean canInterpret(String input, Menu menu);
    void interpret(String input, Menu menu);

    default String[] getArgs(Inputable inputable, String input) {
        String withoutPattern = input.replace(inputable.getPattern() + " ", "");

        return withoutPattern.split(" ");
    }

}
