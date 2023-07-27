package com.company.laba6;

import java.util.Scanner;

public class example_24_04_1 {
    public static int doubleFactor(int number) {
        int result = 1;

        for(;  number >= 2; number -=2) {
            result *= number;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.print("Введите число: ");

        int number = console.nextInt();
        System.out.printf("\nДвойной факториал числа равен: %d", doubleFactor(number));
    }
}
