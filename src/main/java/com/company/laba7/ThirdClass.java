package com.company.laba7;

public class ThirdClass extends SecondClass {
    public String text;

    public ThirdClass(char symbol, int number, String text) {
        super(symbol, number);
        this.text = text;
    }

    public ThirdClass(ThirdClass instance) {
        super(instance.symbol, instance.number);
        this.text = instance.text;
    }

    public String toString() {
        return String.format("parent(%s); class: %s; text: %s", super.toString(), ThirdClass.class.getSimpleName(), this.text);
    }
}
