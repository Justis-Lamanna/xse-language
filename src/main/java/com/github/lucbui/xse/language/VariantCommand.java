package com.github.lucbui.xse.language;

public class VariantCommand extends BasicCommand {
    private final int variant;

    public VariantCommand(String name, String description, ReadOnlyIterable<ParameterDescription<SizedParameter>> parameters, int variant) {
        super(name, description, parameters);
        this.variant = variant;
    }

    public int getVariant() {
        return variant;
    }
}
