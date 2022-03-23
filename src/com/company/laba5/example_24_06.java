package com.company.laba5;

import java.util.Scanner;

public class example_24_06 {
    public static void main(String[] args) {
        System.out.println("\nВведите минимальное и максималньое значение через пробел: ");

        Scanner console = new Scanner(System.in);
        int min = console.nextInt(), max = console.nextInt();

        Range range = new Range(min, max);
        range.printFields();

        while(true) {
            System.out.println("\nВведите новое значение: ");
            int value = console.nextInt();

            range.setFields(value);

            range.printFields();
        }
    }
}
