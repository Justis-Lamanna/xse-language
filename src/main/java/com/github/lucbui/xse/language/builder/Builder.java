package com.github.lucbui.xse.language.builder;

/**
 * An interface which marks this class as a builder
 * @param <BUILT> The built object type
 */
public interface Builder<BUILT> {
    /**
     * Build the object this builder is supposed to build
     * @return The built object
     */
    BUILT build();
}
