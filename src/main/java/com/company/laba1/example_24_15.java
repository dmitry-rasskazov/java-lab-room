package com.company.laba1;

import java.util.Scanner;

public class example_24_15 {
    public static void main(String[] args) {
        Scanner consoleIn = new Scanner(System.in);

        System.out.println("Input first number: ");
        int firstNumber = consoleIn.nextInt();
        System.out.println("Input second number: ");
        int secondNumber = consoleIn.nextInt();

        System.out.printf("\nSum this numbers is %d\n", firstNumber + secondNumber);

        consoleIn.close();
    }
}
