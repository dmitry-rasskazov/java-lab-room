package com.company.timus;

import java.util.*;

public class Pow {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int N, M, Y;
        List<Integer> results = new ArrayList<>();

        N = console.nextInt();
        M = console.nextInt();
        Y = console.nextInt();

        for (int i = 0; i < M; i++) {
            if(pow(i, N, M) == Y) {
                results.add(i);
            }
        }

        if(results.size() == 0) {
            System.out.print(-1);
            return;
        }

        Collections.sort(results);

        boolean space = false;
        for (int x: results) {
            System.out.print(space ? " " + x : x);
            space = true;
        }
    }

    static int pow(int base, int n, int mod) {
        if(n < 1) {
            return 1;
        }

        int c = 1;
        for(int i = 0; i < n; i++) {
            c = (c * base) % mod;
        }

        return c;
    }
}

/**
 * 1110. Степень
 * Ограничение времени: 0.5 секунды
 * Ограничение памяти: 64 МБ
 * Даны целые числа N, M и Y. Напишите программу, которая найдёт все целые числа X в диапазоне [0, M – 1], такие что XN mod M = Y.
 * Исходные данные
 * Ввод содержит единственную строку с числами N, M и Y (0 < N < 999, 1 < M < 999, 0 < Y < 999), записанными через пробел.
 * Результат
 * Выведите все числа X через пробел в одной строке. Числа должны идти в порядке возрастания. Если искомых чисел нет, выведите −1.
 */