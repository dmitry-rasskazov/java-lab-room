package com.company.timus;

import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseSqrt {
    public static void main(String[] args) throws IOException {
        StringBuilder inputStr = new StringBuilder();
        InputStreamReader reader = new InputStreamReader(System.in, "ISO-8859-1");

        do{
            inputStr.append((char) reader.read());
        } while (reader.ready());

        String[] parts = inputStr.toString().split("\\s+");

        for(int i = parts.length - 1; i >= 0; --i) {
            if(parts[i] != null && !parts[i].equals("")) {
                System.out.printf("%.4f\n", Math.sqrt(Long.parseLong(parts[i])));
            }
        }
    }
}


/**
 * №1001
 *
 * Обратный корень
 *
 * Исходные данные
 * Входной поток содержит набор целых чисел Ai (0 ≤ Ai ≤ 1018),
 * отделённых друг от друга произвольным количеством пробелов и переводов строк. Размер входного потока не превышает 256 КБ.
 *
 *
 * Результат
 * Для каждого числа Ai, начиная с последнего и заканчивая первым, в отдельной строке вывести его квадратный корень не
 * менее чем с четырьмя знаками после десятичной точки.
 */