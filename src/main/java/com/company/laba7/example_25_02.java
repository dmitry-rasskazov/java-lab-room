package com.company.laba7;

import java.util.Scanner;

public class example_25_02 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.println("С каким значеним поля создать экземпляр суперкласса?");
        TextSuperClass parentClass = new TextSuperClass(console.nextLine());
        System.out.printf("Экземпляр суперкласса имеет следующие значения полей: \n\t%s\n", parentClass.toString());
        System.out.println("Какое значение текстового поля присвоить суперклассу?");
        parentClass.setText(console.nextLine());
        System.out.printf("Экземпляр суперкласса имеет следующие значения полей: \n\t%s\n", parentClass.toString());

        System.out.println("С какими значеними полей создать экземпляр дочернего класса?");
        TextSubClass childClass = new TextSubClass(console.nextLine(), Integer.valueOf(console.nextLine()));

        System.out.printf("Экземпляр дочернего класса имеет следующие значения полей: \n\t%s\n", childClass.toString());
        System.out.println("Какие значения назначить полям дочернего класса?");
        childClass.setText(console.nextLine());
        childClass.setText(Integer.valueOf(console.nextLine()));

        System.out.printf("Экземпляр дочернего класса имеет следующие значения полей: \n\t%s\n", childClass.toString());
    }
}
