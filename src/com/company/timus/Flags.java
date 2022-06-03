package com.company.timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Flags {
    private static Map<String, Long> cache = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(console.readLine());

        System.out.print(countingCombine(null, N));
    }

    private static long countingCombine(Color c, int n) {
        if(n < 1) {
            return 0;
        }

        String key = String.format("%s%d", c == null ? "-" : c.toString(), n);
        if(cache.containsKey(key)) {
            return cache.get(key);
        }

        long result;
        if(n > 1) {
            if(c == null) {
                result = countingCombine(Color.RED, n-1) + countingCombine(Color.WHITE, n-1);
            } else if(c.equals(Color.RED)) {
                result = countingCombine(Color.WHITE, n-1) + (n-2 > 0 ? countingCombine(Color.WHITE, n-2) : 1);
            } else {
                result = countingCombine(Color.RED, n-1) + (n-2 > 0 ? countingCombine(Color.RED, n-2) : 1);
            }
        } else {
            if(c == null) {
                result = 2;
            } else {
                result = 1;
            }
        }

        cache.put(key, result);

        return result;
    }

    private enum Color {
        WHITE,
        RED
    }
}

/**
 * 1225. Флаги
 * Ограничение времени: 1.0 секунды
 * Ограничение памяти: 64 МБ
 * В День флага России владелец магазина решил украсить свою витрину полосками ткани белого, синего и красного цветов. Он хочет, чтобы выполнялись следующие условия:
 *
 *     Полоски одного цвета не должны располагаться рядом друг с другом.
 *     Синяя полоска может быть расположена только между белой и красной или между красной и белой.
 *
 * Определите количество способов выполнить желание владельца магазина.
 * Например, для N = 3 возможны следующие варианты:
 * Problem illustration
 * Исходные данные
 * N — количество полосок, 1 ≤ N ≤ 45.
 * Результат
 * M — количество способов украсить витрину.
 */
