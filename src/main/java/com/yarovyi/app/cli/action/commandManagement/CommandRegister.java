package com.yarovyi.app.cli.action.commandManagement;

import com.yarovyi.app.cli.action.commandManagement.command.Command;
import com.yarovyi.app.cli.exception.CommandNotFoundException;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class CommandRegister {
    private final Set<Command> commands = new HashSet<>();

    public CommandRegister() {}

    public void addCommand(Command command) {
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
