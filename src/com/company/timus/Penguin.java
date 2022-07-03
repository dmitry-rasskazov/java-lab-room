package com.company.timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Penguin {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 20);

        int N = Short.parseShort(br.readLine());
        int[] counts = {0, 0, 0};

        for (int i = 0; i < N; i++) {
            String view = br.readLine();
            if(view.charAt(0) == 'E') {
                counts[0]++;
            } else if(view.charAt(0) == 'L') {
                counts[1]++;
            } else if (view.charAt(0) == 'M') {
                counts[2]++;
            }
        }

        if(counts[0] >= counts[1] && counts[1] >= counts[2]) {
            System.out.println("Emperor Penguin");
        } else if(counts[0] >= counts[1] && counts[0] <= counts[2]) {
            System.out.println("Macaroni Penguin");
        } else {
            System.out.println("Little Penguin");
        }
    }
}
