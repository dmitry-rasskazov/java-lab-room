package com.company.laba2;

import java.util.Scanner;

public class example_24_04 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.println("Введите целое число:");
        int number = console.nextInt();
        String message;

        if(number >= 5 && number <= 10) {
            message = "";
        } else {
            message = "не ";
        }

        System.out.printf("\nВведённое число %d %sпопадает в диапозон от 5 до 10 включительно", number, message);
    }
}
