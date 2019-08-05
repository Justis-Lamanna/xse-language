package com.github.lucbui.xse.language.parameter;

import java.util.Objects;

public class OrParameter implements Parameter {
    private Parameter p1;
    private Parameter p2;

    public OrParameter(Parameter p1, Parameter p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public static class Sized implements SizedParameter {
        private SizedParameter p1;
        private SizedParameter p2;

        public Sized(SizedParameter p1, SizedParameter p2){
            Objects.requireNonNull(p1);
            Objects.requireNonNull(p2);
            if(p1.getNumberOfBytes() != p2.getNumberOfBytes()){
                throw new IllegalArgumentException("Both parameter types must be of same size");
            }
            this.p1 = p1;
            this.p2 = p2;
        }


        @Override
        public int getNumberOfBytes() {
            return p1.getNumberOfBytes();
        }
    }
}
