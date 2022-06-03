package com.company.timus;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;
import java.util.TreeSet;

public class DigitPow {
    private static final InputStream console = System.in;

    public static void main(String[] args) throws IOException {
        int N = nextInt();
        Set<Integer> set = setNumbers(new TreeSet<>());
        boolean[] results = new boolean[N];

        for(int i = 0; i < N; i++) {
            results[i] = set.contains(nextInt());
        }

        for(int i = 0; i < N; i++, System.out.print(" ")) {
            System.out.print(results[i] ? 1 : 0);
        }
    }

    private static Set<Integer> setNumbers(Set<Integer> set) {
        int i = 1, j = 0;
        for(; i < 2147483647 && i+ (j+1) > -1; set.add(i), i += ++j);
        set.add(i);

        return set;
    }

    private static int nextInt() throws IOException {
        StringBuilder buffer = new StringBuilder();
        char c;
        int buf;
        while ((buf = console.read()) != -1 && (c = (char) buf) >= (int) '0' && c <= (int) '9') {
            buffer.append(c);
        }

        if(buffer.length() > 0) {
            return Integer.parseInt(buffer.toString());
        }

        return nextInt();
    }
}

/**
 * 1209. 1, 10, 100, 1000...
 * Ограничение времени: 1.0 секунды
 * Ограничение памяти: 64 МБ
 * Представим себе бесконечную последовательность цифр, составленную из записанных друг за другом возрастающих степеней десятки. Вот начало этой последовательности: 110100100010000… Всё, что надо — определить, какая цифра находится в такой последовательности на определённом месте.
 * Исходные данные
 * В первой строке находится целое число N (1 ≤ N ≤ 65535). В i-й из N последующих строк записано целое число Ki — номер позиции в последовательности (1 ≤ Ki ≤ 231 − 1).
 * Результат
 * Выведите через пробел N цифр. i-я цифра должна равняться цифре, которая находится в описанной выше последовательности на позиции с номером Ki.
 */