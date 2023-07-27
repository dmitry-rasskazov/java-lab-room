package com.company.laba7;

public class SSubClass extends GrantClass {
    protected char symbol;

    public SSubClass(String text, char symbol) {
        super(text);
        this.symbol = symbol;
    }

    @Override
    public void print() {
        System.out.printf("class: %s; text: %s; symbol: %s", this.getClass().getSimpleName(), this.text, this.symbol);
    }
}
