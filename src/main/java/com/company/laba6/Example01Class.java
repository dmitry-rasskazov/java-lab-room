package com.company.laba6;

public class Example01Class {
    private char symbol;
    private String text;

    public Example01Class() {}

    public void set(char symbol) {
        this.symbol = symbol;
    }

    public void set(String text) {
        this.text = text;
    }

    public void set(char[] array) {
        if(1 == array.length) {
            this.symbol = array[0];
        } else {
            this.text = String.valueOf(array);
        }
    }

    public char symbol() {
        return this.symbol;
    }

    public String text() {
        return this.text;
    }
}
