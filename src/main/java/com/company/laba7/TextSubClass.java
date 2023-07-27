package com.company.laba7;

public class TextSubClass extends TextSuperClass {
    public int number;

    public TextSubClass(String text, int number) {
        super(text);
        this.number = number;
    }

    @Override
    public void setText() {
        super.setText();
        this.number = 0;
    }

    @Override
    public void setText(String text) {
        super.setText(text);
    }

    public void setText(int number) {
        this.number = number;
    }

    public void setText(String text, int number) {
        super.setText(text);
        this.number = number;
    }

    @Override
    public String toString() {
        return String.format("Super class(%s); number: %d", super.toString(), this.number);
    }
}
