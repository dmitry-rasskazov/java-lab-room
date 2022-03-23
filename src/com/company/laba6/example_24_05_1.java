package com.company.laba6;

import java.util.Scanner;

public class example_24_05_1 {
    public static long sumSqr(int number) {
        int result = 0;

        for(int i = 1; i <= number; i++) {
            result += i*i;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.print("Введите число: ");

        int number = console.nextInt();
        System.out.printf("\nСумма квадратов чисел до заданного равна: %d", sumSqr(number));
    }
}
