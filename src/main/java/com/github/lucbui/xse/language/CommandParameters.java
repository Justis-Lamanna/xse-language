package com.github.lucbui.xse.language;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * Encapsulates multiple command parameters
 * Serves as a semi-drop-in replacement for an array, with the bonus that the array can't be modified after changing.
 */
public class CommandParameters implements Iterable<CommandParameter>{

    public static final CommandParameters NO_PARAMS = new CommandParameters(new CommandParameter[0]);

    private CommandParameter[] commandParameters;

    /**
     * Create a CommandParameters from multiple CommandParameter
     * @param commandParameters
     */
    public CommandParameters(CommandParameter[] commandParameters) {
        this.commandParameters = Arrays.copyOf(commandParameters, commandParameters.length);
    }

    public CommandParameters(List<CommandParameter> parameters) {
        this.commandParameters = parameters.toArray(new CommandParameter[0]);
    }

    /**
     * Get the number of parameters
     * @return The number of parameters.
     */
    public int length(){
        return commandParameters.length;
    }

    /**
     * Get the parameter at the specified index
     * @param idx The index to retrieve
     * @return The retrieved index.
     */
    public CommandParameter at(int idx){
        return commandParameters[idx];
    }

    @Override
    public Iterator<CommandParameter> iterator() {
        return Arrays.stream(commandParameters).iterator();
    }

    /**
     * Get a stream of the CommandParameters inside this object
     * @return A stream of CommandParameter objects
     */
    public Stream<CommandParameter> stream(){
        return Arrays.stream(commandParameters);
    }
}
