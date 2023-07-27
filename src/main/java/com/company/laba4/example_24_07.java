package com.company.laba4;

import java.util.Scanner;

public class example_24_07 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.println("Введите ширину и выоту массива через пробел:");
        int width = console.nextInt();
        int height = console.nextInt();

        int[][] array1 = new int[height][width];
        int count = 0;

        for (int i = 0; i < height; i++) {
            if(i % 2 == 0) {
                for(int j = 0; j < width; j++, count++) {
                    array1[i][j] = count;
                }
            } else {
                for(int j = width-1; j >= 0; j--, count++) {
                    array1[i][j] = count;
                }
            }
        }

        for (int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                System.out.printf("\t%d", array1[i][j]);
            }
            System.out.print('\n');
        }
    }
}
