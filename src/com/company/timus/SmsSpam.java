package com.company.timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SmsSpam {
    private static final char MODIFICATOR = 'a' - 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 10000);

        int result = 0;
        String input = br.readLine();

        for (char symbol: input.toCharArray()) {
            if(symbol >= 'a' && symbol <= 'z') {
                int buf = (symbol - MODIFICATOR) % 3;
                result += buf == 0 ? 3 : buf;
            } else {
                switch (symbol) {
                    case ',': result += 2; break;
                    case '!': result += 3; break;
                    default: result++;
                }
            }
        }

        System.out.println(result);
    }
}
