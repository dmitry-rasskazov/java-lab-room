package com.company.laba8;

import java.util.Scanner;

public class example_25_02 {
    public static void printBinaryString(int number) {
        if(number != 0) {
            int mod = number % 2;
            printBinaryString((number - mod) / 2);
            System.out.print(0 != mod ? 1 : 0);
        }
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.print("Введите число для перевода в двоичную систему: ");
        int number = Integer.parseInt(console.next());
        System.out.print("\nРезультат: ");
        printBinaryString(number);
    }
}
