package com.github.lucbui.xse.language.builder;

import com.github.lucbui.xse.language.*;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to build out commands
 */
public class BasicCommandBuilder implements CommandBuilder<BasicCommandBuilder, BasicCommand>{
    private String name;
    private String description;
    private List<ParameterDescription<SizedParameter>> parameters;

    public BasicCommandBuilder(String name){
        this.name = name;
        this.parameters = new ArrayList<>();
    }

    /**
     * Add a description to this command
     * @param description The command's description
     * @return This builder
     */
    @Override
    public BasicCommandBuilder withDescription(String description){
        this.description = description;
        return this;
    }

    /**
     * Add a parameter to this command
     * @param SizedParameter The parameter type
     * @param description The parameter description
     * @return This builder
     */
    @Override
    public BasicCommandBuilder withParam(SizedParameter SizedParameter, String description){
        parameters.add(new ParameterDescription<>(SizedParameter, description));
        return this;
    }

    @Override
    public BasicCommand build(){
        return new BasicCommand(name, description, new ReadOnlyIterable<>(parameters));
    }
}
