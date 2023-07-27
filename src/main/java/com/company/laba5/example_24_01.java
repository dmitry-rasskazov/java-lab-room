package com.company.laba5;

import java.util.Scanner;

public class example_24_01 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.println("Введите символ: ");
        Symbol symbol = new Symbol();

        symbol.setSymbol(console.next().charAt(0));

        System.out.println("Вы ввели символ: ");
        symbol.printValue();
        System.out.printf("Код символа: %d\n", symbol.getCode());
    }
}
