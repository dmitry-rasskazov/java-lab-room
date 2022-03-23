package com.company.laba7;

public class FirstClass {
    public char symbol;

    public FirstClass(char symbol) {
        this.symbol = symbol;
    }

    public FirstClass(FirstClass instance) {
        this.symbol = instance.symbol;
    }

    @Override
    public String toString() {
        return String.format("class: %s; symbol: %s", FirstClass.class.getSimpleName(), this.symbol);
    }
}
