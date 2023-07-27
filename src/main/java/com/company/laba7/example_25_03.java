package com.company.laba7;

import java.util.Scanner;

public class example_25_03 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.print("Введите число для старшего суперкласса: ");
        SuperClass sc = new SuperClass((int) Integer.valueOf(console.nextLine()));
        System.out.println();

        System.out.print("Введите число и символ для суперкласса: ");
        ChildClass cc = new ChildClass(Integer.valueOf(console.next()), console.next().charAt(0));
        System.out.println();

        System.out.print("Введите число, символ и строку для дочернего класса: ");
        GrandsonClass gc = new GrandsonClass(Integer.valueOf(console.next()), console.next().charAt(0), console.next());
        System.out.println();

        System.out.printf(
                "В результате инициализации объектов классов, получились следующие строки: \n\t%s\n\t%s\n\t%s",
                sc.toString(),
                cc.toString(),
                gc.toString()
        );
    }
}
