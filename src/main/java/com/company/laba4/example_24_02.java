package com.company.laba4;

public class example_24_02 {
    private static final int HEIGHT = 11;
    private static final int WIGHT = 11;

    public static void main(String[] args) {
        for(int i = 0; i < HEIGHT; i++) {
            for(int j = i; j < WIGHT; j++) {
                if(i == HEIGHT-1 || j == WIGHT-1 || i == 0 || j == i) {
                    System.out.print('*');
                } else {
                    System.out.print(' ');
                }
            }
            System.out.print('\n');
        }
    }
}
