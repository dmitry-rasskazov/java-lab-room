package com.company.laba1;

import java.util.Scanner;

public class example_24_08 {
    public static void main(String[] args) {
        Scanner consoleIn = new Scanner(System.in);

        System.out.println("Input surname: ");
        String surname = consoleIn.nextLine();

        System.out.println("Input name: ");
        String name = consoleIn.nextLine();

        System.out.println("Input patronymic: ");
        String patronymic = consoleIn.nextLine();

        System.out.printf("\nHello %s %s %s\n", surname, name, patronymic);

        consoleIn.close();
    }
}
