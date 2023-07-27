package com.company.laba1;

import java.util.Scanner;

public class example_24_11 {
    public static void main(String[] args) {
        Scanner consoleIn = new Scanner(System.in);

        System.out.println("Input month name: ");
        String month = consoleIn.nextLine();
        System.out.println("Count of days: ");
        int count = consoleIn.nextInt();

        System.out.printf("\nThe month %s contains %d days\n", month, count);

        consoleIn.close();
    }
}
