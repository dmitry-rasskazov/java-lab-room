package com.company.laba6;

import java.util.Scanner;

public class example_24_05_2 {
    public static long sumSqr(int number) {
        if(1 >= number) {
            return 1;
        }

        return (long) number*number + sumSqr(number - 1);
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.print("Введите число: ");

        int number = console.nextInt();
        System.out.printf("\nСумма квадратов чисел до заданного равна: %d", sumSqr(number));
    }
}
