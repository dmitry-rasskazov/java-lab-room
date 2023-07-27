package com.company.laba7;

public class SecondClass extends FirstClass{
    public int number;

    public SecondClass(char symbol, int number) {
        super(symbol);
        this.number = number;
    }

    public SecondClass(SecondClass instance) {
        super(instance.symbol);
        this.number = instance.number;
    }

    @Override
    public String toString() {
        return String.format("parent(%s); class: %s; number: %s", super.toString(), SecondClass.class.getSimpleName(), this.number);
    }
}
