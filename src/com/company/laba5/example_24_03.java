package com.company.laba5;

import java.util.Scanner;

public class example_24_03 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.print("Введите число - начало диапозона: ");
        int from = console.nextInt();
        System.out.println();
        System.out.print("Введите число - конец диапозона: ");
        int to = console.nextInt();
        System.out.println();

        NumberRange rangeNon = new NumberRange();
        NumberRange rangeSingle = new NumberRange(from);
        NumberRange rangeDouble = new NumberRange(from, to);

        System.out.printf("Без конструктора, диапозон от %d до %d\n", rangeNon.from, rangeNon.to);
        System.out.printf("С одним аргументом в конструкторе, диапозон от %d до %d\n", rangeSingle.from, rangeSingle.to);
        System.out.printf("С двумя аргументами  в конструкторе, диапозон от %d до %d\n", rangeDouble.from, rangeDouble.to);
    }
}
