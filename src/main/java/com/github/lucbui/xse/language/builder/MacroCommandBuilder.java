package com.github.lucbui.xse.language.builder;

import com.github.lucbui.xse.language.Command;
import com.github.lucbui.xse.language.MacroCommand;
import com.github.lucbui.xse.language.ParameterDescription;
import com.github.lucbui.xse.language.ReadOnlyIterable;
import com.github.lucbui.xse.language.parameter.CommandParameter;
import com.github.lucbui.xse.language.parameter.Parameter;
import com.github.lucbui.xse.language.parameter.SizedParameter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MacroCommandBuilder implements CommandBuilder<MacroCommandBuilder, MacroCommand> {

    private String name;
    private String description;
    private List<ParameterDescription<SizedParameter>> parameters;
    private List<String> macros;

    public MacroCommandBuilder(String name){
        this.name = name;
    }

    @Override
    public MacroCommandBuilder withDescription(String description) {
       this.description = description;
       return this;
    }

    @Override
    public MacroCommandBuilder withParam(SizedParameter sizedParameter, String description) {
        this.parameters.add(new ParameterDescription<>(sizedParameter, description));
        return this;
    }

    /**
     * Add a command to this macro
     * @param commandName The command's name. Resolved at build
     * @return This instance
     */
    public MacroCommandBuilder withCommand(String commandName){
        this.macros.add(commandName);
        return this;
    }

    @Override
    public MacroCommand build() {
        throw new IllegalStateException("Macro builder requires a LanguageBuilder parameter");
    }

    @Override
    public MacroCommand build(LanguageBuilder builder){
        List<Command> commands = macros.stream()
                .map(i -> Optional.ofNullable(builder.commandByName.get(i)).orElseThrow(IllegalArgumentException::new))
                .collect(Collectors.toList());
        return new MacroCommand(name, description, new ReadOnlyIterable<>(parameters), new ReadOnlyIterable<>(commands));
    }
}
