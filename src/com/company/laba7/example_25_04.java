package com.company.laba7;

import java.util.Scanner;

public class example_25_04 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.print("Введите сомвол для первого суперкласса: ");
        FirstClass f = new FirstClass(console.next().charAt(0));
        FirstClass f_c = new FirstClass(f);
        System.out.println();

        System.out.print("Введите символ и число для второго суперкласса: ");
        SecondClass s = new SecondClass(console.next().charAt(0), Integer.valueOf(console.next()));
        SecondClass s_c = new SecondClass(s);
        System.out.println();

        System.out.print("Введите сомвол, число и строку для третьего класса: ");
        ThirdClass t = new ThirdClass(console.next().charAt(0), Integer.valueOf(console.next()), console.next());
        ThirdClass t_c = new ThirdClass(t);
        System.out.println();

        System.out.printf(
                "В результате инициализации объектов классов и их клонирования, получились следующие строки: \n\t%s\n\t%s\n\t%s",
                f_c.toString(),
                s_c.toString(),
                t_c.toString()
        );
    }
}
