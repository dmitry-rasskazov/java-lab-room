package com.company.laba1;

import java.util.Date;
import java.util.Scanner;

public class example_24_14 {
    public static void main(String[] args) {
        Scanner consoleIn = new Scanner(System.in);

        System.out.println("Input your ages: ");
        int year = consoleIn.nextInt();

        Date nowDate = new Date();
        int nowYear = nowDate.getYear() + 1900; // Метод возвращает число лет, считая за нулевой - 1900 год

        System.out.printf("\nYour year of birth is %d\n", nowYear - year);

        consoleIn.close();
    }
}
