package com.github.lucbui.xse.language;

/**
 * Encapsulates a command parameter.
 */
public class CommandParameter {
    private IParameter IParameter;
    private String description;

    /**
     * Create a command parameter
     * @param IParameter The parameter type
     * @param description The parameter description
     */
    public CommandParameter(IParameter IParameter, String description) {
        this.IParameter = IParameter;
        this.description = description;
    }

    /**
     * Get the parameter type.
     * @return The parameter type.
     */
    public IParameter getParameter() {
        return IParameter;
    }

    /**
     * Get a description of the parameter
     * @return The parameter description.
     */
    public String getDescription() {
        return description;
    }
}
