package com.company.laba7;

public class GrantClass {
    protected String text;

    public GrantClass(String text) {
        this.text = text;
    }

    public void print() {
        System.out.printf("class: %s; text: %s", this.getClass().getSimpleName(), this.text);
    }
}
