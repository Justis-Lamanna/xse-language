package com.github.lucbui.xse.language;

import java.util.Objects;

/**
 * Encapsulates a basic command, which has exactly one footprint.
 * This command is compiled as one byte, for the command ID, followed by zero or more additional parameters
 * to the command. All basic commands have the same quantity and type of parameters.
 */
public class BasicCommand implements Command {

    private String name;
    private String description;
    private CommandParameters parameters;

    /**
     * Create a basic command
     * @param name The name of the command
     * @param description The description of the command
     * @param parameters The parameters this command takes.
     */
    public BasicCommand(String name, String description, CommandParameters parameters) {
        this.name = name;
        this.description = description;
        this.parameters = Objects.requireNonNull(parameters);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public CommandParameters getParameters() {
        return parameters;
    }

    /**
     * Get the number of bytes in this command.
     * This is equivalent to 1 (for the command itself), followed by all its parameters.
     * @return
     */
    @Override
    public int getNumberOfBytes() {
        return 1 + parameters.stream()
                .mapToInt(p -> p.getParameter().getNumberOfBytes())
                .sum();
    }
}
