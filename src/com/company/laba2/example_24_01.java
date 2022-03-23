package com.company.laba2;

import java.util.Scanner;

public class example_24_01 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.println("Введите целое число:");
        int number = console.nextInt();
        String message;

        if(number % 3 == 0) {
            message = "\nВведённое число %d делатся на 3";
        } else {
            message = "\nВведённое число %d не делатся на 3";
        }

        System.out.printf(message, number);
    }
}
