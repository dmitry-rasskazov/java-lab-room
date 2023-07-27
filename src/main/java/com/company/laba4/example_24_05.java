package com.company.laba4;

import java.util.Random;
import java.util.Scanner;

public class example_24_05 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("Введите размерность матрицы, указав число строк и число столбцов через пробел: ");
        int width = console.nextInt();
        int height = console.nextInt();

        int[][] target = new int[width][height];

        System.out.println("Заполнили массив:");
        for(int obcissus = 0; obcissus < width; obcissus++) {
            for(int ordinate = 0; ordinate < height; ordinate++) {
                target[obcissus][ordinate] = rand.nextInt(9);
                System.out.print(target[obcissus][ordinate]);
            }
            System.out.print('\n');
        }

        System.out.println("\nЗаменили строки массива столбцами:");
        for(int obcissus = 0; obcissus < height; obcissus++) {
            for(int ordinate = 0; ordinate < width; ordinate++) {
                System.out.print(target[ordinate][obcissus]);
            }
            System.out.print('\n');
        }
    }
}
