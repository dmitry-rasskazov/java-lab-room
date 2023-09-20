package com.company.laba2;

import java.util.Scanner;

public class example_24_02 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.println("Введите целое число:");
        int number = console.nextInt();
        String message;

        if(number % 5 == 2 && number % 7 == 1) {
            message = "\nВведённое число %d при делении на 5 даёт в остате 2, а при делении на 7 - в остатке 1";
        } else {
            message = "\nВведённое число %d не даёт в остате 2, а при делении на 7 - в остатке 1";
        }

        System.out.printf(message, number);
    }
}
