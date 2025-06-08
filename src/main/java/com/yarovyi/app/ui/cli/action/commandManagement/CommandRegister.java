package com.yarovyi.app.ui.cli.action.commandManagement;

import com.yarovyi.app.ui.cli.action.commandManagement.command.Command;
import com.yarovyi.app.ui.cli.exception.CommandNotFoundException;
import com.yarovyi.app.ui.cli.context.AppContext;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Manages CLI commands registered for a specific {@link com.yarovyi.app.ui.cli.menu.Menu menu}.
 * <p>
 *     Allows each menu to maintain its own set of {@link Command commands},
 *     enabling context-specific command behavior.
 * </p>
 *
 * @since 1.0
 * @author Bohdan Yarovyi
 */
public class CommandRegister {
    private final Set<Command> commands = new HashSet<>();
    private final AppContext context;

    public CommandRegister(AppContext context) {
        this.context = context;
    }

    /**
     * Registers a new {@link Command} and assigns the shared application context to it.
     *
     * @param command the command to register
     */
    public void addCommand(Command command) {
        command.setApplicationContext(context);
        commands.add(command);
    }

    /**
     * Checks user input if matches with any having commands.
     *
     * @param userInput the raw user input.
     * @return {@code true} if a matching command exists; {@code false} otherwise.
     */
    public boolean isCommand(String userInput) {
        return findCommand(userInput).isPresent();
    }

    /**
     * Retrieves a {@link Command command} by pattern from user input.
     *
     * @param userInput the raw user input.
     * @return {@link Command command} if it was found by given pattern in user input;
     *          Otherwise throws runtime exception {@link CommandNotFoundException}
     */
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
        return Collections.unmodifiableSet(commands);
    }

}
