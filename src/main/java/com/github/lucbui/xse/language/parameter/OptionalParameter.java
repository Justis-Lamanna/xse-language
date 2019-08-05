package com.github.lucbui.xse.language.parameter;

public class OptionalParameter implements Parameter {
    private Parameter type;

    public OptionalParameter(Parameter type) {
        this.type = type;
    }
}
