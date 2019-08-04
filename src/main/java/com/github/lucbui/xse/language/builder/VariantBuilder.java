package com.github.lucbui.xse.language.builder;

import com.github.lucbui.xse.language.ParameterDescription;
import com.github.lucbui.xse.language.ReadOnlyIterable;
import com.github.lucbui.xse.language.SizedParameter;
import com.github.lucbui.xse.language.VariantCommand;

import java.util.ArrayList;
import java.util.List;

public class VariantBuilder implements CommandBuilder<VariantBuilder, VariantCommand> {
    String name;
    String description;
    List<ParameterDescription<SizedParameter>> parameters;
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
    public VariantBuilder withParam(SizedParameter SizedParameter, String description) {
        this.parameters.add(new ParameterDescription<>(SizedParameter, description));
        return this;
    }

    @Override
    public VariantCommand build() {
        return new VariantCommand(this.name, this.description, new ReadOnlyIterable<>(this.parameters),
                this.variantParameterValue);
    }
}
