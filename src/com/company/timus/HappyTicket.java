package com.company.timus;

import java.io.IOException;

public class HappyTicket {
    public static void main(String[] args) throws IOException {
        int A = 0, B = 0;
        int buf, counter = 0;
        boolean captured = false;
        while ((buf = System.in.read()) != -1) {
            if(buf >= '0' && buf <= '9') {
                captured = true;
                if(counter > 2) {
                    if(buf - '0' == 9) {System.out.print("No"); return;}
                    B += buf - '0';
                } else {
                    A += buf - '0';
                }

            } else if(captured && (buf == ' ' || buf == '\n')) {
                break;
            }
            counter++;
        }

        System.out.print("Yes");
    }
}
