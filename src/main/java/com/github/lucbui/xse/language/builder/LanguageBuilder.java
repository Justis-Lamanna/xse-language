package com.github.lucbui.xse.language.builder;

import com.github.lucbui.xse.language.*;

import java.util.*;

/**
 * Helper class to create a Language
 */
public class LanguageBuilder {
    Map<String, BasicCommand> commandByName;
    Map<String, List<VariantCommand>> commandVariantsByName;
    Map<String, PreprocessingDirective> preprocessingDirectivesByName;

    /**
     * Create a LanguageBuilder
     */
    public LanguageBuilder(){
        this.commandByName = new HashMap<>();
        this.commandVariantsByName = new HashMap<>();
        this.preprocessingDirectivesByName = new HashMap<>();
    }

    /**
     * Add a command to the language.
     * A command added this way should be associated with one, and only one, name. If a duplicate name is found, an exception
     * is thrown. Use overrideCommand to overwrite a previously created command.
     * @param builder A builder which builds a command
     * @return This instance, for chaining
     * @see BasicCommandBuilder
     */
    public LanguageBuilder withCommand(Builder<? extends BasicCommand> builder){
        BasicCommand command = builder.build();
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
    public LanguageBuilder overrideCommand(Builder<? extends BasicCommand> builder){
        BasicCommand command = builder.build();
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
    public LanguageBuilder withVariantCommand(Builder<? extends Collection<? extends VariantCommand>> builder){
        for(VariantCommand command : builder.build()){
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
    public LanguageBuilder overrideVariantCommand(Builder<? extends Collection<? extends VariantCommand>> builder){
        Collection<? extends VariantCommand> commands = builder.build();
        commands.stream()
                .map(Command::getName)
                .distinct()
                .forEach(name -> this.commandVariantsByName.remove(name));

        for(VariantCommand command : commands){
            this.commandVariantsByName.computeIfAbsent(command.getName(), s -> new ArrayList<>()).add(command);
        }
        return this;
    }

    /**
     * Delete all variant commands to the language with this name
     * @param name The name of the command to delete
     * @return This instance, for chaining
     */
    public LanguageBuilder deleteVariantCommand(String name){
        this.commandVariantsByName.remove(name);
        return this;
    }

    /**
     * Adds a preprocessing directive to the language.
     * A preprocessing directive is used to modify the compiler functionality in some way. These are not compiled into
     * the script.
     * @param builder A builder which creates a Preprocessing directive
     * @return This instance, for chaining
     */
    public LanguageBuilder withPreprocessingDirective(Builder<? extends PreprocessingDirective> builder){
        PreprocessingDirective directive = builder.build();
        if(this.preprocessingDirectivesByName.containsKey(directive.getName())){
            throw new IllegalArgumentException("Map already contains key for " + directive.getName() + ".");
        }
        for(String alias : directive.getAliases()){
            if (this.preprocessingDirectivesByName.containsKey(alias)) {
                throw new IllegalArgumentException("Map already contains key for " + alias + ".");
            }
        }

        this.preprocessingDirectivesByName.put(directive.getName(), directive);
        for(String alias : directive.getAliases()){
            this.preprocessingDirectivesByName.put(alias, directive);
        }

        return this;
    }

    /**
     * Modify a preprocessing directive for a language.
     * A preprocessing directive is used to modify the compiler functionality in some way. These are not compiled into
     * the script. All old aliases are removed.
     * @param builder A builder which builds multiple commands
     * @return This instance, for chaining
     * @see VariantCommandBuilder
     */
    public LanguageBuilder overridePreprocessingDirective(Builder<? extends PreprocessingDirective> builder){
        PreprocessingDirective directive = builder.build();
        PreprocessingDirective oldDirective = this.preprocessingDirectivesByName.remove(directive.getName());
        if(oldDirective != null) {
            for (String alias : oldDirective.getAliases()) {
                this.preprocessingDirectivesByName.remove(alias);
            }
        }

        this.preprocessingDirectivesByName.put(directive.getName(), directive);
        for(String alias : directive.getAliases()){
            this.preprocessingDirectivesByName.put(alias, directive);
        }

        return this;
    }

    /**
     * Delete a preprocessing directive from the language
     * All aliases are deleted as well.
     * @param name The name of the command to delete
     * @return This instance, for chaining
     */
    public LanguageBuilder deletePreprocessingDirective(String name){
        PreprocessingDirective directive = this.preprocessingDirectivesByName.get(name);
        if(directive != null){
            this.preprocessingDirectivesByName.remove(name);
            for(String alias : directive.getAliases()){
                this.preprocessingDirectivesByName.remove(alias);
            }
        }

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
