package com.yarovyi.app.ui.cli.menu.handler.inputInterpreter;

import com.yarovyi.app.ui.cli.action.commandManagement.Command;
import com.yarovyi.app.ui.cli.action.commandManagement.CommandRegister;
import com.yarovyi.app.ui.cli.menu.Menu;

public class CommandInterpreter implements Interpreter {

    @Override
    public boolean canInterpret(String input, Menu menu) {
        return menu.getCommandRegister().isCommand(input);
    }

    @Override
    public void interpret(String input, Menu menu) {
        CommandRegister commandRegister = menu.getCommandRegister();
        Command command = commandRegister.getCommand(input);

        String[] args = getArgs(command, input);
        command.execute(menu, args);
    }

}
