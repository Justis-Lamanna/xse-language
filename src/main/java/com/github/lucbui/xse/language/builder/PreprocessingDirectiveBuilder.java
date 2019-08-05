package com.github.lucbui.xse.language.builder;

import com.github.lucbui.xse.language.*;
import com.github.lucbui.xse.language.parameter.Parameter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A builder which creates a preprocessing directive
 */
public class PreprocessingDirectiveBuilder implements Builder<PreprocessingDirective> {

    private String name;
    private String description;
    private List<ParameterDescription<Parameter>> parameters;
    private List<String> aliases;

    /**
     * Initialize the builder with a name, and zero or more aliases
     * @param name The name of the directive
     * @param aliases The aliases of the directive
     */
    public PreprocessingDirectiveBuilder(String name, String... aliases){
        this.name = name;
        this.parameters = new ArrayList<>();
         this.aliases = (aliases == null || aliases.length == 0) ? new ArrayList<>() : new ArrayList<>(Arrays.asList(aliases));
    }

    /**
     * Set the description of the directive
     * @param description The description
     * @return This instance
     */
    public PreprocessingDirectiveBuilder withDescription(String description){
        this.description = description;
        return this;
    }

    /**
     * Add a parameter to the directive
     * @param parameter The parameter to use
     * @param description The description of the parameter
     * @return This instance
     */
    public PreprocessingDirectiveBuilder withParam(Parameter parameter, String description){
        this.parameters.add(new ParameterDescription<>(parameter, description));
        return this;
    }

    /**
     * Add an alias to the directive
     * @param alias The alias to use
     * @return This instance
     */
    public PreprocessingDirectiveBuilder withAlias(String alias){
        this.aliases.add(alias);
        return this;
    }

    @Override
    public PreprocessingDirective build() {
        return new PreprocessingDirective(name, description, new ReadOnlyIterable<>(parameters), new ReadOnlyIterable<>(aliases));
    }
}
