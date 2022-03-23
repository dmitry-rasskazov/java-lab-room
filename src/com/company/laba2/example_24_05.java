package com.company.laba2;

import java.util.Scanner;

public class example_24_05 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.println("Введите целое число:");
        int number = console.nextInt();
        int result = (number % 10000) / 1000;

        System.out.printf("\nЧётвёртая цифра справа у числа %d = %d", number, result);
    }
}