package com.company.laba4;

public class example_24_01 {
    private static final int HEIGHT = 11;
    private static final int WIGHT = 23;

    public static void main(String[] args) {
        for(int i = 0; i < HEIGHT; i++) {
            for(int j = 0; j < WIGHT; j++) {
                if(i == HEIGHT-1 || j == WIGHT-1 || i == 0 || j == 0) {
                    System.out.print('*');
                } else {
                    System.out.print(' ');
                }
            }
            System.out.print('\n');
        }
    }
}
