package com.github.lucbui.xse.language.parameter;

public class VarargsParameter implements Parameter {
    Parameter parameter;

    public VarargsParameter(Parameter parameter) {
        this.parameter = parameter;
    }
}
