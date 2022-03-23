package com.company.laba7;

import java.util.Scanner;

public class example_25_05 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.print("Введите текст для суперкласса: ");
        GrantClass g = new GrantClass(console.nextLine());
        System.out.println();

        System.out.print("Введите текст и число для первого класса: ");
        FSubClass f = new FSubClass(console.next(), Integer.valueOf(console.next()));
        System.out.println();

        System.out.print("Введите текст и символ для второго класса: ");
        SSubClass s = new SSubClass(console.next(), console.next().charAt(0));
        System.out.println();

        System.out.print("Введите текст и символ для второго класса, который доступен поссылке суперкласса: ");
        GrantClass s_2 = new SSubClass(console.next(), console.next().charAt(0));
        System.out.println();

        System.out.println("\nВывод первого объекта: ");
        g.print();
        System.out.println("\nВывод второго объекта: ");
        f.print();
        System.out.println("\nВывод третьего объекта: ");
        s.print();
        System.out.println("\nВывод четвёртого объекта: ");
        s_2.print();
    }
}
