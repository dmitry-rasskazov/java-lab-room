package com.company.laba6;

public class example_24_02 {
    public static void main(String[] args) {
        for(int i = 0; i < 10; ++i) {
            System.out.printf("Текущее значение счётчика: %d\n", RequestCounter.incrementCount());
        }
    }
}
