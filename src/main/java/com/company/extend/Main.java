package com.company.extend;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Scanner console = new Scanner(new BufferedInputStream(System.in, 1024));
        Factory factory = new Factory();

        BaseClass example1, example2;

        example1 = factory.create(console.nextLine(), console.nextByte());
        example2 = factory.create(console.nextLine(), console.nextByte());
    }
}
