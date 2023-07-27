package com.company.laba4;

import java.util.Random;
import java.util.Scanner;

public class example_24_06 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.println("Введите размерность матрицы, указав число строк и число столбцов через пробел: ");
        int width = console.nextInt();
        int height = console.nextInt();

        int minWidth = width-1, minHeight = height-1;

        int[][] source = new int[width][height];

        int[][] target = new int[minWidth][minHeight];
        Random rand = new Random();

        int removeX = rand.nextInt(minWidth);
        int removeY = rand.nextInt(minHeight);

        System.out.println("Заполнили массив:");
        for(int obcissus = 0; obcissus < width; obcissus++) {
            for(int ordinate = 0; ordinate < height; ordinate++) {
                source[obcissus][ordinate] = rand.nextInt(9);
                System.out.print(source[obcissus][ordinate]);
            }
            System.out.print('\n');
        }

        System.out.printf("\nУдаляем строку  %d, столбец %d\n", removeX+1, removeY+1);

        System.out.println("\nПочистили массив:");
        for(int obcissus = 0, minObcissus = 0; obcissus < width; obcissus++) {
            if(obcissus == removeX) {
                continue;
            }
            for(int ordinate = 0, minOrdinate = 0; ordinate < height; ordinate++) {
                if(ordinate == removeY) {
                    continue;
                }
                target[minObcissus][minOrdinate] = source[obcissus][ordinate];
                System.out.print(target[minObcissus][minOrdinate]);
                minOrdinate++;
            }
            System.out.print('\n');
            minObcissus++;
        }
    }
}
