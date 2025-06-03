package com.yarovyi.app.ui.menuHandling;

import com.yarovyi.app.ui.cli.menu.handler.MenuHandler;
import com.yarovyi.app.ui.cli.menu.handler.inputInterpreter.CommandInterpreter;
import com.yarovyi.app.ui.cli.menu.handler.inputInterpreter.Interpreter;
import com.yarovyi.app.ui.cli.menu.handler.inputInterpreter.OperationInterpreter;
import com.yarovyi.app.ui.cli.menu.handler.inputInterpreter.SubmenuInterpreter;
import com.yarovyi.app.ui.util.Console;

import java.util.ArrayList;
import java.util.List;

public class SimpleMenuHandler extends MenuHandler {

    @Override
    public String getUserInput() {
        return Console.getUserInput();
    }

}
