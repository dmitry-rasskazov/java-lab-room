package com.company.laba2;

import java.util.Scanner;

public class example_24_03 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.println("Введите целое число:");
        int number = console.nextInt();
        String message;

        if(number % 4 == 0 && number >= 10) {
            message = "\nВведённое число %d удовлетворяет критериям делимости на 4 абсолютному значению не меньше 10";
        } else {
            message = "\nВведённое число %d не удовлетворяет критериям делимости на 4 абсолютному значению не меньше 10";
        }

        System.out.printf(message, number);
    }
}