package com.company.laba11;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class example_25_03 {
    public static void readAllByArray(InputStream in) throws IOException {
        byte[] buff = new byte[5];
        while (true) {
            int count = in.read(buff);
            if(count != -1) {
                System.out.println("кол-во="
                        + count
                        + " "
                        + ", buff="
                        + Arrays.toString(buff)
                        + " "
                        + ", str="
                        + new String(buff, 0, count));
            } else {
                break;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        try(InputStream inFile = new FileInputStream("D:\\tmp\\test.txt")) {
            readAllByArray(inFile);
        } catch (IOException e) {
            System.out.println("Ошибка в файле D:\\tmp\\test.txt");
        }
    }
}
