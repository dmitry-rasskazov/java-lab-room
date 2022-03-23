package com.company.laba5;

public class AlphabetRange {
    private char from, to;

    public AlphabetRange(char from, char to)
    {
        if(from > to) {
            System.out.println("Bad range!");
            System.exit(1);
        }
        this.from = from;
        this.to = to;
    }

    public void printRange()
    {
        System.out.println("Все символы диапозона:");
        for(int i = this.from; i <= this.to; ++i) {
            System.out.println((char) i);
        }
    }
}
