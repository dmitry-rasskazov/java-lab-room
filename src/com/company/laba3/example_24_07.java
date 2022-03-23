package com.company.laba3;

import java.util.Scanner;

public class example_24_07 {
    private static final int chFirstCode = 'a'; // код символа 'a'
    private static final int chLastCode = chFirstCode + 25; // код сичвола 'z'

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Введите размер массива: ");

        int length = 0;
        if(!console.hasNextInt() || (length = console.nextInt()) < 0) {
            System.out.println("Вы ввели некорректное число! Попробуйте снова\n");
            main(args);
            return;
        }

        char[] list = new char[length];

        System.out.println("Вывод массива в прямом порядке:");
        for(int i = chFirstCode, count = 0; count < length; i = i < chLastCode ? i+1 : chFirstCode) {
            if((i-chFirstCode) % 2 == 0) {
                list[count] = (char) i;
                System.out.print(list[count]);
                count++;
            }
        }

        System.out.println("\nВывод массива в обратном порядке:");
        for(int i = list.length - 1; i >= 0; i--) {
            System.out.print(list[i]);
        }
    }
}
