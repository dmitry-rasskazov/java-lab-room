package com.company.laba11;

import java.io.*;
import java.util.Random;

public class example_25_11 {
    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("D:\\tmp\\input11.txt");
        File output = new File("D:\\tmp\\output11.txt");

        try(
                DataOutputStream wf1 = new DataOutputStream(new FileOutputStream(input));
                DataOutputStream wf2 = new DataOutputStream(new FileOutputStream(output));
        ) {
            Random rand = new Random();
            double j = rand.nextDouble();
            wf1.writeUTF("example1\n");
            wf1.writeUTF("example2\n");
            for (int i = 0; i < 5; i++, j = rand.nextDouble()) {
                wf1.writeDouble(j);
            }
            wf1.flush();

            DataInputStream rf1 = new DataInputStream(new FileInputStream(input));
            rf1.readUTF();
            wf2.writeUTF(rf1.readUTF());
            while(true) {
                try {
                    double buff = rf1.readDouble();
                    if(buff >= 0) {

                        wf2.writeDouble(buff);
                    }
                }catch (IOException e) {
                    break;
                }
            }

            wf2.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
