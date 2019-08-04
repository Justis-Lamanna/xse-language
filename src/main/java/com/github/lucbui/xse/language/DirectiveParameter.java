package com.github.lucbui.xse.language;

/**
 * Parameters for preprocessing directives
 */
public enum DirectiveParameter implements Parameter {
    /**
     * This parameter can be anything
     */
    ANYTHING,
    /**
     * This parameter can be any text
     */
    TEXT,
    /**
     * This parameter can be ON or OFF
     */
    ON_OFF;
}
