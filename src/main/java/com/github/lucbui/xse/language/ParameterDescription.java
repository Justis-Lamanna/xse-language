package com.github.lucbui.xse.language;

/**
 * Encapsulates a command parameter.
 */
public class ParameterDescription<T extends Parameter> {
    private T parameter;
    private String description;

    /**
     * Create a command parameter
     * @param parameter The parameter type
     * @param description The parameter description
     */
    public ParameterDescription(T parameter, String description) {
        this.parameter = parameter;
        this.description = description;
    }

    /**
     * Get the parameter type.
     * @return The parameter type.
     */
    public T getParameter() {
        return parameter;
    }

    /**
     * Get a description of the parameter
     * @return The parameter description.
     */
    public String getDescription() {
        return description;
    }
}
