package com.company.smpp;

public class OverLoadTest
{
    public static void main(String[] args)
    {
        Integer test = !"null".isEmpty() && "null".equals("null") ? Integer.parseInt("0") : null;

        System.out.println(test);
    }
}
