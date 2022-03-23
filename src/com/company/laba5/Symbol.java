package com.company.laba5;

public class Symbol {
    private char value;

    public Symbol() {}

    public int getCode()
    {
        return this.value;
    }

    public void setSymbol(char value)
    {
        this.value = value;
    }

    public void printValue()
    {
        System.out.println(this.value);
    }
}
