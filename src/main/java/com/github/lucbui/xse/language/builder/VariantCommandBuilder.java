package com.github.lucbui.xse.language.builder;

import com.github.lucbui.xse.language.*;
import com.github.lucbui.xse.language.parameter.SizedParameter;

import java.util.ArrayList;
import java.util.List;

/**
 * A builder which creates variant commands
 */
public class VariantCommandBuilder implements CommandBuilder<VariantCommandBuilder, List<VariantCommand>>{
    private String name;
    private String description;
    private List<ParameterDescription<SizedParameter>> parameters;

    private List<VariantCommand> variants;

    /**
     * Initializes a variant command with a name
     * @param name The name of the command
     */
    public VariantCommandBuilder(String name) {
        this.name = name;
        this.parameters = new ArrayList<>();
        this.variants = new ArrayList<>();
    }

    @Override
    public VariantCommandBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public VariantCommandBuilder withParam(SizedParameter SizedParameter, String description) {
        this.parameters.add(new ParameterDescription<>(SizedParameter, description));
        return this;
    }

    /**
     * Adds a variant to this builder.
     * @param builder A builder which constructs a variant
     * @return This instance
     */
    public VariantCommandBuilder withVariant(VariantBuilder builder){
        List<ParameterDescription<SizedParameter>> parameters = new ArrayList<>(this.parameters);
        parameters.addAll(builder.parameters);
        VariantCommand command = new VariantCommand(this.name, builder.description, new ReadOnlyIterable<>(parameters), builder.variantParameterValue);
        variants.add(command);
        return this;
    }

    @Override
    public List<VariantCommand> build() {
        return variants;
    }

}
