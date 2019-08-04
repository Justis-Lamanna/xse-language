package com.github.lucbui.xse.language.builder;

import com.github.lucbui.xse.language.SizedParameter;

/**
 * A common interface which is used by CommandBuilders
 * @param <SELF> The implementing type
 * @param <BUILT> The type to build
 */
public interface CommandBuilder<SELF, BUILT> extends Builder<BUILT>{
    /**
     * Adds a command description
     * @param description The command's description
     * @return This instance, or a new instance
     */
    SELF withDescription(String description);

    /**
     * Adds a new command parameter
     * @param sizedParameter The parameter
     * @param description The description of the parameter
     * @return This instance, or a new instance
     */
    SELF withParam(SizedParameter sizedParameter, String description);
}
