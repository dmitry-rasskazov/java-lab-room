package com.company.laba5;

import java.util.Scanner;

public class example_24_02 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.print("Введите символ начала диапозона: ");
        char from = console.next().charAt(0);
        System.out.println();
        System.out.print("Введите символ начала диапозона: ");
        char to = console.next().charAt(0);
        System.out.println();

        AlphabetRange range = new AlphabetRange(from, to);

        range.printRange();
    }
}
