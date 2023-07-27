package com.company.laba3;

import java.util.Scanner;

public class example_24_03_1 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Введите длину ряда фибоначи:");
        int length = console.nextInt();
        long preNumber = 0, currentNumber = 1;

        for(int i = 1; i <= length; i++) {
            System.out.printf("%d\t", currentNumber);
            currentNumber += preNumber;
            preNumber = currentNumber - preNumber;
            if(i % 5 == 0) System.out.print("\n");
        }
    }
}
