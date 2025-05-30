package com.yarovyi.app.cli.action.commandManagement;

import com.yarovyi.app.cli.action.commandManagement.command.Command;
import com.yarovyi.app.cli.exception.CommandNotFoundException;
import com.yarovyi.app.context.AppContext;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class CommandRegister {
    private final Set<Command> commands = new HashSet<>();
    private final AppContext context;

    public CommandRegister(AppContext context) {
        this.context = context;
    }

    public void addCommand(Command command) {
        command.setApplicationContext(context);
        commands.add(command);
    }

    public boolean isCommand(String userInput) {
        return findCommand(userInput).isPresent();
    }

    public Command getCommand(String userInput) {
        return findCommand(userInput)
                .orElseThrow(CommandNotFoundException::new);
    }

    private Optional<Command> findCommand(String userInput) {
        return this.commands.stream()
                .filter(c -> c.isCommandMatches(userInput))
                .findFirst();
    }

    public Set<Command> getCommands() {
        return commands;
    }

}
