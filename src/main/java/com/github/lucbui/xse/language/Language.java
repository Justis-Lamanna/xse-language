package com.github.lucbui.xse.language;

import java.util.List;

/**
 * Encapsulates a language of commands
 */
public interface Language {
    /**
     * Get the command by its name
     * @param commandName The command's name
     * @return The command
     */
    List<? extends Command> getCommandByName(String commandName);

    /**
     * Get all commands
     * @return All commands
     */
    List<? extends Command> getCommands();
}
