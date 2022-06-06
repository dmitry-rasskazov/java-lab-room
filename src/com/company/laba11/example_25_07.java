package com.company.laba11;

import java.io.*;

public class example_25_07 {
    public static void main(String[] args) {

        try(
                BufferedReader br = new BufferedReader(new FileReader("D:\\tmp\test.txt"), 1024);
                BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\tmp\test2.txt"))
        ) {


            int count = 0;

            String s;
            while ((s = br.readLine()) != null) {
                count++;
                System.out.println(count + ": " + s);
                bw.write(s);
                bw.newLine();
            }

            bw.flush();
        } catch (IOException e) {
            System.out.println("Ошибка!");
        }
    }
}
