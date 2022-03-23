package com.company.laba8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class example_25_03 {
    public static void scanInts(Collection<Integer> collection, Scanner scanner) {
        System.out.print("> ");
        if(scanner.hasNextInt()) {
            collection.add(Integer.parseInt(scanner.next()));
            scanInts(collection, scanner);
        } else {
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        List<Integer> array = new ArrayList<>();

        System.out.println("Вводите целые числа до тех пор, пока это нужно. Что-бы завершить ввод, введите любой другой символ: ");
        scanInts(array, console);

        System.out.println("Были введени следующие числа: ");
        for (Integer number: array) {
            System.out.printf("%d | ", number);
        }
    }
}
