package com.github.lucbui.xse.language;

/**
 * The type of parameter passed into an XSE command
 */
public enum CommandParameter implements SizedParameter {
    /**
     * A byte parameter
     */
    BYTE(1),
    /**
     * A word parameter, which takes 2 bytes
     */
    WORD(2),
    /**
     * A double-word parameter, which takes 4 bytes
     */
    DOUBLE(4),
    /**
     * A flag ID, which takes 2 bytes
     */
    FLAG(2),
    /**
     * A variable ID, which takes 2 bytes
     */
    VARIABLE(2),
    /**
     * A pointer, which takes 4 bytes
     */
    POINTER(4),
    /**
     * A variable ID, or a constant word value
     */
    VARIABLE_OR_WORD(2),
    /**
     * The ID of a Pokémon species
     */
    POKEMON_ID(2),
    /**
     * The Item ID of a Pokémon species
     */
    ITEM_ID(2),
    /**
     * The Decoration ID of a decoration
     */
    DECORATION_ID(2),
    /**
     * The ID of a sound or music
     */
    SOUND_ID(2),
    /**
     * The ID of a battle move
     */
    MOVE_ID(2);

    private int numberOfBytes;

    CommandParameter(int numberOfBytes) {
        this.numberOfBytes = numberOfBytes;
    }

    @Override
    public int getNumberOfBytes() {
        return numberOfBytes;
    }
}
