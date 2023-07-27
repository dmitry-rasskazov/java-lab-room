package com.company.timus;

import java.io.*;

public class Hotel {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 10);
        short N = Short.parseShort(br.readLine());

        int[] wor = new int[N];

        for(short i = 0; i < N; i++) {
            int num = firstNumber(i);
            short index = (short) (N-1);
            StringBuilder result = new StringBuilder();
            for(short j = i; j < N; j++, num += j, index--) {
                wor[index] = num;
            }
            num--;
            for(short j = (short) (N-1); j > (N-1-i); j--, num += j, index--) {
                wor[index] = num;
            }
            for (short j = 0; j < N; j++) {
                if(j < (short) (N-1)) {
                    result.append(wor[j]).append(" ");
                } else {
                    result.append(wor[j]);
                }
            }
            System.out.println(result);
        }
    }

    private static int firstNumber(short n) {
        int result = 0;

        for(short i = 0; i <= n; i++, result += i);

        return result;
    }
}
