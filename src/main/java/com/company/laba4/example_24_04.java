package com.company.laba4;

public class example_24_04 {
    private static final int HEIGHT = 11;
    private static final int WIGHT = 11;

    public static void main(String[] args) {
        int[][] matrix = new int[WIGHT][HEIGHT];

        for(int i = 0; i < WIGHT; i++) {
            for(int j = i; j < HEIGHT; j++) {
                matrix[i][j] = 2;
                System.out.print(matrix[i][j]);
            }
            System.out.print('\n');
        }
    }
}
