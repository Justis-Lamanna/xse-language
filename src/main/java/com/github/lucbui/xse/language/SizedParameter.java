package com.github.lucbui.xse.language;

/**
 * A parameter that has a compiled size
 */
public interface SizedParameter extends Parameter{
    /**
     * @return The number of byte this parameter takes
     */
    int getNumberOfBytes();
}
