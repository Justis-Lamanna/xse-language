package com.github.lucbui.xse.language.builder;

import com.github.lucbui.xse.language.BasicCommand;
import com.github.lucbui.xse.language.CommandParameter;
import com.github.lucbui.xse.language.CommandParameters;
import com.github.lucbui.xse.language.IParameter;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to build out commands
 */
public class BasicCommandBuilder implements CommandBuilder<BasicCommandBuilder, BasicCommand>{
    private String name;
    private String description;
    private List<CommandParameter> parameters;

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
     * @param IParameter The parameter type
     * @param description The parameter description
     * @return This builder
     */
    @Override
    public BasicCommandBuilder withParam(IParameter IParameter, String description){
        parameters.add(new CommandParameter(IParameter, description));
        return this;
    }

    @Override
    public BasicCommand build(){
        return new BasicCommand(name, description, new CommandParameters(parameters));
    }
}
