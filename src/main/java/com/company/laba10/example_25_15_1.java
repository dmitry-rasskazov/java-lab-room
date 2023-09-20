package com.company.laba10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class example_25_15_1 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        List<Integer> array = new ArrayList<>();

            System.out.print("Введите целое число: ");

            int result = 0;
            int len = 0;
            boolean positiveEmpty = true;
            try {
                while(console.hasNext()) {
                    try {
                        String buffer = console.nextLine();
                        if(buffer.equals("q")) {
                            break;
                        }
                        array.add(Integer.valueOf(buffer));
                        System.out.print("Введите следующее целое число: ");
                    } catch (NumberFormatException e) {
                        System.out.println(e.getMessage());
                        System.out.print("Введите следующее целое число: ");
                    }
                }

                for (Integer item: array) {
                    result = item >= 0 ? result+item : result;
                    len = item >= 0 ? len+1 : len;

                    positiveEmpty = positiveEmpty && item < 0;
                }

                if(positiveEmpty) {
                    throw new RuntimeException("Отсутствуют положительные элементы!");
                }
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }


        System.out.println(result / len);
    }
}
