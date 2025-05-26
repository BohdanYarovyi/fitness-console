package com.yarovyi.app.cli.menu.handler.interpreter;

import com.yarovyi.app.cli.menu.Menu;

public interface Interpreter {

    boolean canInterpret(String input, Menu menu);
    void interpret(String input, Menu menu);

}
