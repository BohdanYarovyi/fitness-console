package com.yarovyi.app.ui.menu.handler;

import com.yarovyi.app.ui.menu.Menu;
import com.yarovyi.app.ui.menu.handler.interpreter.Interpreter;

import java.util.List;

public interface MenuHandler {

    String getUserInput();
    List<Interpreter> getInterpreters();

    default void handleMenu(Menu menu) {
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

}
