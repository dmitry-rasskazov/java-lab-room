package com.company.laba3;

import java.util.Scanner;

public class example_24_01 {
    public static void main(String[] args) {
        Scanner consoleIn = new Scanner(System.in);

        System.out.println("Введите номер дня недели:");
        int dayNumber = consoleIn.nextInt();

        switch (dayNumber) {
            case 1: System.out.println("Понедельник");
                break;
            case 2: System.out.println("Вторник");
                break;
            case 3: System.out.println("Среда");
                break;
            case 4: System.out.println("Четверг");
                break;
            case 5: System.out.println("Пятница");
                break;
            case 6: System.out.println("Суббота");
                break;
            case 7: System.out.println("Воскресенье");
                break;
            default: main(args);
        }
    }
}
