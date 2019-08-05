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

    /**
     * Build the object this builder is supposed to build
     * @param builder The Language Builder, in the case additional context is needed
     * @return The built object
     */
    default BUILT build(LanguageBuilder builder){
        return build();
    }
}
