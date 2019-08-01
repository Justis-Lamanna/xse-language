package com.github.lucbui.xse.language.builder;

import com.github.lucbui.xse.language.*;

import java.util.ArrayList;
import java.util.List;

public class VariantCommandBuilder implements CommandBuilder<VariantCommandBuilder, List<VariantCommand>>{
    private String name;
    private String description;
    private List<CommandParameter> parameters;

    private List<VariantCommand> variants;

    public VariantCommandBuilder(String name, String description, List<CommandParameter> parameters) {
        this.name = name;
        this.description = description;
        this.parameters = parameters;

        this.variants = new ArrayList<>();
    }

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
    public VariantCommandBuilder withParam(IParameter IParameter, String description) {
        this.parameters.add(new CommandParameter(IParameter, description));
        return this;
    }

    public VariantCommandBuilder withVariant(VariantBuilder builder){
        List<CommandParameter> parameters = new ArrayList<>(this.parameters);
        parameters.addAll(builder.parameters);
        VariantCommand command = new VariantCommand(this.name, builder.description, new CommandParameters(parameters), builder.variantParameterValue);
        variants.add(command);
        return this;
    }

    @Override
    public List<VariantCommand> build() {
        return variants;
    }

}
