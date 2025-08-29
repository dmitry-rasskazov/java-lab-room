package com.company.timus;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LongTasksCondition
{
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 16565);

    public static void main(String[] args) throws Exception
    {
        int h, w, n, size, rows = 0, rowLength = 0, pages = 0;
        String[] parameters = reader.readLine().split(" ");

        h = Integer.parseInt(parameters[0]);
        w = Integer.parseInt(parameters[1]);
        n = Integer.parseInt(parameters[2]);

        for(int i = 0; i < n; i++)
        {
            if(rows == 0) {
                pages++;
                rows = 1;
            }


            size = reader.readLine().length();
            rowLength += size;

            if(rowLength < w) {
                rowLength++;
            } else if(rowLength > w) {
                rowLength = size + 1;
                if(++rows > h) {
                    rows = 1;
                    pages++;
                }
            }
        }

        System.out.println(pages);
    }
}
