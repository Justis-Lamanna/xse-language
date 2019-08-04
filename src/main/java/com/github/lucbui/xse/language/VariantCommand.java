package com.github.lucbui.xse.language;

/**
 * A variant command
 * A variant command is several Basic Commands with the same name, but a different footprint.
 */
public class VariantCommand extends BasicCommand {
    private final int variant;

    /**
     * Create a variant parameter
     * @param name The name of the command
     * @param description The commands description
     * @param parameters The parameters the command takes
     * @param variant The variant #
     */
    public VariantCommand(String name, String description, ReadOnlyIterable<ParameterDescription<SizedParameter>> parameters, int variant) {
        super(name, description, parameters);
        this.variant = variant;
    }

    /**
     * Get the variant number
     * @return The variant number
     */
    public int getVariant() {
        return variant;
    }
}
