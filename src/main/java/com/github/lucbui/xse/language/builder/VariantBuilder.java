package com.github.lucbui.xse.language.builder;

import com.github.lucbui.xse.language.CommandParameter;
import com.github.lucbui.xse.language.CommandParameters;
import com.github.lucbui.xse.language.IParameter;
import com.github.lucbui.xse.language.VariantCommand;

import java.util.ArrayList;
import java.util.List;

public class VariantBuilder implements CommandBuilder<VariantBuilder, VariantCommand> {
    String name;
    String description;
    List<CommandParameter> parameters;
    int variantParameterValue;

    public VariantBuilder(int variantParameterValue) {
        this.variantParameterValue = variantParameterValue;
        this.parameters = new ArrayList<>();
    }

    public VariantBuilder(String name, int variantParameterValue){
        this.name = name;
        this.variantParameterValue = variantParameterValue;
        this.parameters = new ArrayList<>();
    }

    @Override
    public VariantBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public VariantBuilder withParam(IParameter IParameter, String description) {
        this.parameters.add(new CommandParameter(IParameter, description));
        return this;
    }

    @Override
    public VariantCommand build() {
        return new VariantCommand(this.name, this.description, new CommandParameters(this.parameters),
                this.variantParameterValue);
    }
}
