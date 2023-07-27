package com.company.laba7;

public class GrandsonClass extends ChildClass {
    public String text;

    public GrandsonClass(int number, char symbol, String text) {
        super(number, symbol);
        this.text = text;
    }

    public void set(int number, char symbol, String text) {
        super.set(number, symbol);
        this.text = text;
    }

    @Override
    public String toString() {
        return String.format(
                "Class name: %s; number: %d; symbol: %s; text: %s",
                GrandsonClass.class.getSimpleName(),
                this.number,
                this.symbol,
                this.text
        );
    }
}
