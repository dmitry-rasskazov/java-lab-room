package com.company.timus;

import java.util.Scanner;

public class ModPow {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int N = console.nextInt();
        float M = console.nextInt();
        int Y = console.nextInt();
        int c = 0;

        for(int i = 0; i < M; i++) {
            if(Math.pow(i, N) % M == Y) {
                System.out.printf((c++ != 0 ? " %d" : "%d"), i);
            }
        }

        if(c == 0) {
            System.out.print(-1);
        }
    }

}
