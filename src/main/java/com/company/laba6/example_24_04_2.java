package com.company.laba6;

import java.util.Scanner;

public class example_24_04_2 {
    public static int doubleFactor(int number) {
        if(1 >= number) {
            return 1;
        }

        return number * doubleFactor(number - 2);
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.print("Введите число: ");

        int number = console.nextInt();
        System.out.printf("\nДвойной факториал числа равен: %d", doubleFactor(number));
    }
}
