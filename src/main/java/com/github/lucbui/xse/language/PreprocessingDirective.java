package com.github.lucbui.xse.language;

/**
 * A preprocessing directive
 * A preprocessing directive dictates to the compiler how it should act. These are not compiled, so inherently have no size.
 */
public class PreprocessingDirective {
    private String name;
    private String description;
    private ReadOnlyIterable<ParameterDescription<Parameter>> parameters;
    private ReadOnlyIterable<String> aliases;

    /**
     * Create a preprocessing directive
     * @param name The name of the directive
     * @param description The description
     * @param parameters The parameters of the directive
     * @param aliases Zero or more aliases of the directive
     */
    public PreprocessingDirective(String name, String description, ReadOnlyIterable<ParameterDescription<Parameter>> parameters, ReadOnlyIterable<String> aliases) {
        this.name = name;
        this.description = description;
        this.parameters = parameters;
        this.aliases = aliases;
    }

    /**
     * Get the name of the directive
     * @return The name of the directive
     */
    public String getName() {
        return name;
    }

    /**
     * Get the description of the directive
     * @return The description of the directive
     */
    public String getDescription() {
        return description;
    }

    /**
     * Get the parameters of the directive
     * @return The parameters of the directive
     */
    public ReadOnlyIterable<ParameterDescription<Parameter>> getParameters() {
        return parameters;
    }

    /**
     * Get the aliases of the directive
     * @return The aliases of the directive
     */
    public ReadOnlyIterable<String> getAliases() {
        return aliases;
    }
}
