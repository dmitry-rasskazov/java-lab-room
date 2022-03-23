package com.company.laba3;

import java.util.Scanner;

public class example_24_02_1 {
    public static void main(String[] args) {
        Scanner consoleIn = new Scanner(System.in);

        System.out.println("Введите название дня недели:");
        String dayName = consoleIn.next().toLowerCase();

        if(dayName.equals("monday") || dayName.equals("понедельник")) {
            System.out.println(1);
        }else if(dayName.equals("tuesday") || dayName.equals("вторник")) {
            System.out.println(2);
        }else if(dayName.equals("wednesday") || dayName.equals("среда")) {
            System.out.println(3);
        }else if(dayName.equals("thursday") || dayName.equals("четверг")) {
            System.out.println(4);
        }else if(dayName.equals("friday") || dayName.equals("пятница")) {
            System.out.println(5);
        }else if(dayName.equals("saturday") || dayName.equals("суббота")) {
            System.out.println(6);
        }else if(dayName.equals("sunday") || dayName.equals("вокскресенье")) {
            System.out.println(7);
        }else {
            System.out.println("Введено неверное называние дня недели!\n");
            main(args);
        }
    }
}
