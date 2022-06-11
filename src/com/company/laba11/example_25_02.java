package com.company.laba11;

import java.io.*;
import java.net.URL;

public class example_25_02 {
    public static void readAllByByte(InputStream in) throws IOException {
        while (true) {
            int oneByte = in.read();

            if(oneByte != -1) {
                System.out.print((char) oneByte);
            } else {
                System.out.print("\n" + "end");
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        InputStream inFile = new FileInputStream("D:/tmp/input10.txt");
        readAllByByte(inFile);
        System.out.println("\n\n");
        inFile.close();

        InputStream inUrl = new URL("https://google.com").openStream();
        readAllByByte(inUrl);
        System.out.println("\n\n");
        inFile.close();

        InputStream inArray = new ByteArrayInputStream(new byte[] {48, 2, 3, 4, 5});
        readAllByByte(inArray);
        System.out.println("\n\n");
        inFile.close();
    }
}
