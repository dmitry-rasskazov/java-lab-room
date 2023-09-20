package com.company.timus;

import java.io.IOException;

public class Selections {
    public static void main(String[] args) throws IOException {
        int N = nextInt();
        int M = nextInt();
        short[] candidates = new short[N];

        for (int i = 0; i < M; i++) {
            int index = nextInt()-1;
            candidates[index]++;
        }

        for (int i = 0; i < N; i++) {
            System.out.printf("%.2f%%\n", ((float) candidates[i] / M) * 100);
        }
    }

    private static int nextInt() throws IOException {
        int result = 0;
        int buf;
        boolean captured = false;
        while ((buf = System.in.read()) != -1) {
            if(buf >= '0' && buf <= '9') {
                captured = true;
                result = (result * 10) + (buf - '0');
            } else if(captured && (buf == ' ' || buf == '\n')) {
                break;
            }
        }

        return result;
    }
}
