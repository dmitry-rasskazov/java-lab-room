package com.company.laba5;

public class Structure {
    private int number;
    private char symbol;

    public Structure(int number, char symbol)
    {
        this.number = number;
        this.symbol = symbol;
    }

    public Structure(double code)
    {
        this.number = (int) code;
        this.symbol = (char) ((code * 100) % 100);
    }

    public int number()
    {
        return this.number;
    }

    public char symbol()
    {
        return this.symbol;
    }
}
