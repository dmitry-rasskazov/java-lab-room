package com.company.laba7;

import java.util.Scanner;

public class example_25_01 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.println("С каким значеним поля создать экземпляр суперкласса?");
        ParentString parentString = new ParentString(console.nextLine());
        System.out.println("С каким значеним поля создать первый экземпляр класса потомка?");
        ChildString firstChild = new ChildString(console.nextLine());
        System.out.println("С какими значеними полей создать второй экземпляр класса потомка?");
        ChildString secondChild = new ChildString(console.nextLine(), console.nextLine());

        System.out.printf("Экземпляр суперкласса имеет следующее значение поля: \n\t%s\n", parentString.toString());
        System.out.printf("Первый экземпляр потомка имеет следующее значение поля: \n\t%s\n", firstChild.toString());
        System.out.printf("Второй экземпляр потомка имеет следующие значения полей: \n\t%s\n", secondChild.toString());
    }
}
