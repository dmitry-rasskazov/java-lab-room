package com.company.example;

import java.io.*;
import java.util.Random;

public class RandomTest
{
    private static final Random rand = new Random();

    public static void main(String[] args) throws IOException
    {
        OutputStreamWriter outputStream = new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream("output2.csv")));

        for(int i =0; i < 10000; i++)
        {
            outputStream.append(Integer.toString(rand.nextInt())).append("\n");
        }

        outputStream.flush();

        outputStream.close();
    }

    private static int nextInt ()
    {
        int result = 0;

        for(byte i = 0; i < 32; i++)
        {
            int randValue = rand.nextInt();
            result = (result << 1) + (randValue >= 0 ? 1 : 0);
        }

        return result;
    }
}
