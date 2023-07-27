package com.company.laba3;

import java.util.Scanner;

public class example_24_06 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Введите размер массива: ");

        int length = 0;
        if(!console.hasNextInt() || (length = console.nextInt()) < 0) {
            System.out.println("Вы ввели некорректное число! Попробуйте снова\n");
            main(args);
            return;
        }

        int[] list = new int[length];

        for(int i = 1, count = 0; count < length; i++) {
            if(i % 5 == 2) {
                list[count] = i;
                System.out.println(list[count]);
                count++;
            }
        }
    }
}
