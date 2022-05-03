package com.company.laba10;

import java.util.Scanner;

public class example_25_16_2 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        for(int i = 0; i < 1;) {
            System.out.print("Введите номер столбца из мытрица 4 на 4, который хотате вывести: ");
            int number;
            String buffer;
            try {
                buffer = console.nextLine();
                number = Integer.parseInt(buffer);

                checkNumber(number);

                System.out.println("Столбец матрицы:");
                for(int j = 0; j < 4; j++) {
                    System.out.println(matrix[j][number-1]);
                }
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                continue;
            }
        }
    }

    private static void checkNumber(Integer number) throws RuntimeException {
        if(number > 4 || number < 1) {
            throw new RuntimeException(String.format("В матрице отсётствует столбец %d", number));
        }
    }
}
