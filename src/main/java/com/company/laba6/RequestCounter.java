package com.company.laba6;

public class RequestCounter {
    private static int count = 0;

    public static int incrementCount() {
        return count++;
    }
}
