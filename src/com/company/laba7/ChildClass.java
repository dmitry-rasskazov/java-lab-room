package com.company.laba7;

public class ChildClass extends SuperClass{
    public char symbol;

    public ChildClass(int number, char symbol) {
        super(number);
        this.symbol = symbol;
    }

    public void set(int number, char symbol) {
        super.set(number);
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return String.format("Class name: %s; number: %d; symbol: %s", ChildClass.class.getSimpleName(), this.number, this.symbol);
    }
}
