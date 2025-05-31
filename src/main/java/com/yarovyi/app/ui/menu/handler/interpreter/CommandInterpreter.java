package com.yarovyi.app.ui.menu.handler.interpreter;

import com.yarovyi.app.ui.action.commandManagement.CommandRegister;
import com.yarovyi.app.ui.action.commandManagement.command.Command;
import com.yarovyi.app.ui.menu.Menu;

public class CommandInterpreter implements Interpreter {

    @Override
    public boolean canInterpret(String input, Menu menu) {
        return menu.getCommandRegister().isCommand(input);
    }

    @Override
    public void interpret(String input, Menu menu) {
        CommandRegister commandRegister = menu.getCommandRegister();
        Command command = commandRegister.getCommand(input);

        command.execute(menu);
    }

}
