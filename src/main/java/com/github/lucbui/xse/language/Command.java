package com.github.lucbui.xse.language;

/**
 * Encapsulates a script command
 */
public interface Command {
    /**
     * Get the name of the command
     * @return The name of the command
     */
    String getName();

    /**
     * Get the description of the command
     * @return The description of the command
     */
    String getDescription();

    /**
     * Get the parameters of the command
     * @return The parameters of the command
     */
    ReadOnlyIterable<? extends ParameterDescription<?>> getParameters();

    /**
     * Get the number of byte the command takes in ROM.
     * @return The number of bytes needed.
     */
    int getNumberOfBytes();
}
