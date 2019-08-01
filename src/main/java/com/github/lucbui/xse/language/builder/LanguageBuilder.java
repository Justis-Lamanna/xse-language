package com.github.lucbui.xse.language.builder;

import com.github.lucbui.xse.language.*;

import java.util.*;

/**
 * Helper class to create a Language
 */
public class LanguageBuilder {
    Map<String, Command> commandByName;
    Map<String, List<Command>> commandVariantsByName;

    private int commandId = -1;

    /**
     * Create a LanguageBuilder
     */
    public LanguageBuilder(){
        this.commandByName = new HashMap<>();
        this.commandVariantsByName = new HashMap<>();
    }

    /**
     * Add a command to the language.
     * A command added this way should be associated with one, and only one, name. If a duplicate name is found, an exception
     * is thrown. Use overrideCommand to overwrite a previously created command.
     * @param builder A builder which builds a command
     * @return This instance, for chaining
     * @see BasicCommandBuilder
     */
    public LanguageBuilder withCommand(Builder<? extends Command> builder){
        Command command = builder.build();
        if(this.commandByName.containsKey(command.getName())){
            throw new IllegalArgumentException("Map already contains key for " + command.getName() + ". If attempting to do variant commands, use withVariantCommand()");
        }
        this.commandByName.put(command.getName(), command);
        return this;
    }

    /**
     * Modify a command to the language
     * This form can replace a command with a new command of the same name. withCommand() should be used, unless this
     * functionality is required, such as when extending a language.
     * @param builder A builder which builds a command
     * @return This instance, for chaining
     * @see BasicCommandBuilder
     */
    public LanguageBuilder overrideCommand(Builder<? extends Command> builder){
        Command command = builder.build();
        this.commandByName.put(command.getName(), command);
        return this;
    }

    /**
     * Delete a command to the language
     * @param name The name of the command to delete
     * @return This instance, for chaining
     */
    public LanguageBuilder deleteCommand(String name){
        this.commandByName.remove(name);
        return this;
    }

    /**
     * Adds many variant commands to the language.
     * A variant command is several commands with the same name, but different structures. This is used to good effect
     * with trainerbattle, which has different footprints depending on the battle type.
     * @param builder A builder which builds multiple commands
     * @return This instance, for chaining
     * @see VariantCommandBuilder
     */
    public LanguageBuilder withVariantCommand(Builder<? extends Collection<? extends Command>> builder){
        for(Command command : builder.build()){
            this.commandVariantsByName.computeIfAbsent(command.getName(), s -> new ArrayList<>()).add(command);
        }
        return this;
    }

    /**
     * Modify variant commands for a language.
     * A variant command is several commands with the same name, but different structures. This is used to good effect
     * with trainerbattle, which has different footprints depending on the battle type. All variants created by the builder
     * are cleared completely.
     * @param builder A builder which builds multiple commands
     * @return This instance, for chaining
     * @see VariantCommandBuilder
     */
    public LanguageBuilder overrideVariantCommand(Builder<? extends Collection<? extends Command>> builder){
        Collection<? extends Command> commands = builder.build();
        commands.stream()
                .map(Command::getName)
                .distinct()
                .forEach(name -> this.commandVariantsByName.remove(name));

        for(Command command : commands){
            this.commandVariantsByName.computeIfAbsent(command.getName(), s -> new ArrayList<>()).add(command);
        }
        return this;
    }

    /**
     * Delete all variant commands to the language
     * @param name The name of the command to delete
     * @return This instance, for chaining
     */
    public LanguageBuilder deleteVariantCommand(String name){
        this.commandVariantsByName.remove(name);
        return this;
    }

    /**
     * Build the language
     * @return The built language
     */
    public Language build() {
        return new DefaultLanguage(this);
    }
}
