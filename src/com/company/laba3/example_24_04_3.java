package com.company.laba3;

import java.util.Scanner;

public class example_24_04_3 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Введите два разных числа через пробел:");

        int number1 = console.nextInt();
        int number2 = console.nextInt();

        int min = Math.min(number1, number2);
        int max = Math.max(number1, number2);

        int i = min;

        while (i <= max) {
            if (i % 5 == 0) {
                System.out.print("\n");
            }
            System.out.printf("%d\t", i);
            i++;
        }
    }
}
