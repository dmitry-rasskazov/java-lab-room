package com.company.laba4;

import java.util.Scanner;

public class example_24_03 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.println("Введите два ширину и высоту матрицы двумя числами через пробел: ");

        int wight = console.nextInt(), height = console.nextInt();

        int[][] matrix = new int[wight][height];

        for(int i = 0; i < wight; i++) {
            for(int j = 0; j < height; j++) {
                matrix[i][j] = 2;
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
