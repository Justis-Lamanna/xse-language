package com.github.lucbui.xse.language;

public class PreprocessingDirective {
    private String name;
    private String description;
    private ReadOnlyIterable<ParameterDescription<Parameter>> parameters;
    private ReadOnlyIterable<String> aliases;

    public PreprocessingDirective(String name, String description, ReadOnlyIterable<ParameterDescription<Parameter>> parameters, ReadOnlyIterable<String> aliases) {
        this.name = name;
        this.description = description;
        this.parameters = parameters;
        this.aliases = aliases;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public  ReadOnlyIterable<ParameterDescription<Parameter>> getParameters() {
        return parameters;
    }

    public ReadOnlyIterable<String> getAliases() {
        return aliases;
    }
}
