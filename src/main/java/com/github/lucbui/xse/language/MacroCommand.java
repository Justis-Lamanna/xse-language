package com.github.lucbui.xse.language;

import com.github.lucbui.xse.language.parameter.SizedParameter;

public class MacroCommand implements Command {

    private String name;
    private String description;
    private ReadOnlyIterable<ParameterDescription<SizedParameter>> parameters;
    private ReadOnlyIterable<Command> commands;

    public MacroCommand(String name, String description, ReadOnlyIterable<ParameterDescription<SizedParameter>> parameters, ReadOnlyIterable<Command> commands) {
        this.name = name;
        this.description = description;
        this.parameters = parameters;
        this.commands = commands;
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
    public ReadOnlyIterable<? extends ParameterDescription<?>> getParameters() {
        return parameters;
    }

    @Override
    public int getNumberOfBytes() {
        return commands.stream()
                .mapToInt(Command::getNumberOfBytes)
                .sum();
    }
}
