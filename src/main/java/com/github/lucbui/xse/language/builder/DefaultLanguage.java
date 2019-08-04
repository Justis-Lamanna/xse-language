package com.github.lucbui.xse.language.builder;

import com.github.lucbui.xse.language.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A default language, used by the LanguageBuilder class.
 */
class DefaultLanguage implements Language {
    //Enhancement one day: Combine these?
    private final Map<String, List<VariantCommand>> commandVariantsByName;
    private Map<String, BasicCommand> commandsByName;
    private Map<String, PreprocessingDirective> preprocessingDirectivesByName;

    DefaultLanguage(LanguageBuilder lb){
        this.commandsByName = lb.commandByName;
        this.commandVariantsByName = lb.commandVariantsByName;
        this.preprocessingDirectivesByName = lb.preprocessingDirectivesByName;
    }

    @Override
    public List<? extends Command> getCommandByName(String commandName) {
        if(commandsByName.containsKey(commandName)) {
            return Collections.singletonList(commandsByName.get(commandName));
        } else if(commandVariantsByName.containsKey(commandName)){
            return commandVariantsByName.get(commandName);
        }
        return null;
    }

    @Override
    public List<Command> getCommands() {
        return Stream.concat(
                commandVariantsByName.values().stream().flatMap(Collection::stream), commandsByName.values().stream())
                .collect(Collectors.toList());
    }
}
