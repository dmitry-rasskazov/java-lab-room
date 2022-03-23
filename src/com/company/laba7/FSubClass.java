package com.company.laba7;

public class FSubClass extends GrantClass {
    protected int num;

    public FSubClass(String text, int num) {
        super(text);
        this.num = num;
    }

    @Override
    public void print() {
        System.out.printf("class: %s; text: %s; num: %d", this.getClass().getSimpleName(), this.text, this.num);
    }
}
