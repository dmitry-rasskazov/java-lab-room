package com.company.timus;

import java.io.IOException;

public class Protectors {
    public static void main(String[] args) throws IOException {
        int A = nextInt(), B = nextInt();

        if((A & 1) == 0 && (B & 1) == 0) {
            System.out.print((B - A) >> 1);
        } else {
            System.out.print(((B - A) >> 1) + 1);
        }
    }

    private static int nextInt() throws IOException {
        int result = 0;
        int buf;
        boolean captured = false;
        while ((buf = System.in.read()) != -1) {
            if(buf >= '0' && buf <= '9') {
                captured = true;
                result = ((result * 10) + (buf - '0'));
            } else if(captured && (buf == ' ' || buf == '\n')) {
                break;
            }
        }

        return result;
    }
}
