package com.company.timus;

import java.io.*;

public class DonaldPostman {
    private static final char[] ADDRESS = new char[] {
            'A', 'P', 'O', 'R', 'B', 'M', 'S', 'D', 'J', 'G', 'K', 'T', 'W'
    };

    private static final short[] CUPBOARDS = new short[] {
            1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 3, 3, 3
    };

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in), 1024);

        int N = Integer.parseInt(console.readLine());
        short state = 1;
        int result = 0;

        for (int i = 0; i < N; i++){
            short newState = getState(console.readLine());

            if(state == 1) {
                if(newState == 3) {
                    result += 2;
                } else if(newState == 2) {
                    result++;
                }
            } else if(state == 2) {
                if(newState == 3 || newState == 1) {
                    result++;
                }
            } else {
                if(newState == 1) {
                    result += 2;
                } else if(newState == 2) {
                    result++;
                }
            }

            state = newState;
        }

        System.out.print(result);
    }

    private static short getState(String address) {
        for (short i = 0; i < ADDRESS.length; i++) {
            if(address.charAt(0) == ADDRESS[i]) {
                return CUPBOARDS[i];
            }
        }

        return 1;
    }
}
