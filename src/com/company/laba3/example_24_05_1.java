package com.company.laba3;

import java.util.Scanner;

public class example_24_05_1 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Введите количество слагаемых суммы:");

        int length = console.nextInt();
        long result = 0;

        for(int i = 1, count = 0; count < length; i++) {
            if(i % 5 == 2 || i % 3 == 1) {
                result += i;
                System.out.println(i);
                ++count;
            }
        }

        System.out.println("Результат суммирования: " + result);
    }
}
