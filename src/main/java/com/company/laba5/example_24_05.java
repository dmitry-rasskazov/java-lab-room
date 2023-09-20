package com.company.laba5;

import java.util.Scanner;

public class example_24_05 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.print("Введите целое число: ");
        int number = console.nextInt();
        System.out.println();

        SubNumber subNumber1 = new SubNumber();
        SubNumber subNumber2 = new SubNumber();

        subNumber1.setNum();
        subNumber2.setNum(number);

        System.out.printf("Значение введённого числа: %d\n", subNumber1.num());
        System.out.printf("Значение числа по-умолчанию: %d\n", subNumber2.num());
    }
}
