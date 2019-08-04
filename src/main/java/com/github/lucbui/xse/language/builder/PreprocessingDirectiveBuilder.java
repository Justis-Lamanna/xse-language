package com.github.lucbui.xse.language.builder;

import com.github.lucbui.xse.language.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PreprocessingDirectiveBuilder implements Builder<PreprocessingDirective> {

    private String name;
    private String description;
    private List<ParameterDescription<Parameter>> parameters;
    private List<String> aliases;

    public PreprocessingDirectiveBuilder(String name, String... aliases){
        this.name = name;
        this.parameters = new ArrayList<>();
         this.aliases = (aliases == null || aliases.length == 0) ? new ArrayList<>() : new ArrayList<>(Arrays.asList(aliases));
    }

    public PreprocessingDirectiveBuilder withDescription(String description){
        this.description = description;
        return this;
    }

    public PreprocessingDirectiveBuilder withParam(AliasParameter parameter, String description){
        this.parameters.add(new ParameterDescription<>(parameter, description));
        return this;
    }

    public PreprocessingDirectiveBuilder withAlias(String alias){
        this.aliases.add(alias);
        return this;
    }

    @Override
    public PreprocessingDirective build() {
        return new PreprocessingDirective(name, description, new ReadOnlyIterable<>(parameters), new ReadOnlyIterable<>(aliases));
    }
}
