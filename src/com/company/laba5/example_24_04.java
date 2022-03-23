package com.company.laba5;

import java.util.Scanner;

public class example_24_04 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.print("Введите целое число: ");
        int number = console.nextInt();
        System.out.println();
        System.out.print("Введите символ: ");
        char symbol = console.next().charAt(0);
        System.out.println();
        System.out.print("Введите дробное число: ");
        double code = console.nextDouble();
        System.out.println();

        Structure struct1 = new Structure(number, symbol);
        Structure struct2 = new Structure(code);

        System.out.printf("Поля первой структуры: %d, %s\n", struct1.number(), struct1.symbol());
        System.out.printf("Поля второй структуры: %d, %s\n", struct2.number(), struct2.symbol());
    }
}
