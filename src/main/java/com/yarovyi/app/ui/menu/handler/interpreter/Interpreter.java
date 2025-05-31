package com.yarovyi.app.ui.menu.handler.interpreter;

import com.yarovyi.app.ui.menu.Menu;

public interface Interpreter {

    boolean canInterpret(String input, Menu menu);
    void interpret(String input, Menu menu);

}
