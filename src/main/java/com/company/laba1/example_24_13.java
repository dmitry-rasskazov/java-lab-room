package com.company.laba1;

import java.util.Date;
import java.util.Scanner;

public class example_24_13 {
    public static void main(String[] args) {
        Scanner consoleIn = new Scanner(System.in);

        System.out.println("Input name: ");
        String name = consoleIn.nextLine();

        System.out.println("Input year: ");
        int year = consoleIn.nextInt();

        Date nowDate = new Date();
        int nowYear = nowDate.getYear() + 1900; // Метод возвращает число лет, считая за нулевой - 1900 год

        System.out.printf("\nYour name is %s and your ages is %d\n",name, nowYear - year);

        consoleIn.close();
    }
}
