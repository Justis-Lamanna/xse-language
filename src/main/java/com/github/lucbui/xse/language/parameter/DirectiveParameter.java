package com.github.lucbui.xse.language.parameter;

/**
 * Parameters for preprocessing directives
 */
public enum DirectiveParameter implements Parameter {
    /**
     * This parameter can be any text
     */
    TEXT,
    /**
     * This parameter can be any number
     */
    NUMBER,
    /**
     * This parameter can be ON or OFF
     */
    ON_OFF,
    /**
     * This parameter can be 0x0 or 0xFF
     */
    ZERO_OR_FF,
    /**
     * This parameter can be a pointer
     */
    POINTER,
    /**
     * This parameter is a filename
     */
    FILE,
    /**
     * This parameter can be a pointer, or a label to be dynamically found
     */
    POINTER_OR_LABEL,
    /**
     * This parameter specifies the data type of the following values
     */
    DATA_TYPE;
}
