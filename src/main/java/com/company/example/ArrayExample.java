package com.company.example;

import java.util.*;

public class ArrayExample {
    public static void main(String[] args) {
        var list = new ArrayList<Integer>();
        for(int i = 0; i < 50000; i++) {
            list.add(i);
        }

        var stringBuf = new StringBuffer();

        list.forEach(_ -> stringBuf.append("%d"));

        var string = stringBuf.toString();

        var start = System.currentTimeMillis();
        var _ = String.format(string, list);
        var finish = System.currentTimeMillis();

        System.out.println(start - finish);
    }
}
