package com.company.laba3;

import java.util.Scanner;

public class example_24_02_2 {
    public static void main(String[] args) {
        Scanner consoleIn = new Scanner(System.in);

        System.out.println("Введите название дня недели:");
        String dayName = consoleIn.next();

        switch (dayName.toLowerCase()) {
            case "monday":
            case "понедельник": System.out.println(1);
                break;
            case "tuesday":
            case "вторник": System.out.println(2);
                break;
            case "wednesday":
            case "среда": System.out.println(3);
                break;
            case "thursday":
            case "четверг": System.out.println(4);
                break;
            case "friday":
            case "пятница": System.out.println(5);
                break;
            case "saturday":
            case "суббота": System.out.println(6);
                break;
            case "sunday":
            case "вокскресенье": System.out.println(7);
                break;
            default:
                System.out.println("Введено неверное называние дня недели!\n");
                main(args);
        }
    }
}
