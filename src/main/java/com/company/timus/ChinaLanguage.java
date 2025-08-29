package com.company.timus;

import java.io.BufferedReader;

/**
 * 1964. Китайский язык
 * Ограничение времени: 1.0 секунды
 * Ограничение памяти: 64 МБ
 * Вова переехал из Гуанчжоу в Шэньчжэнь. Тут же выяснилось, что местные жители также не понимают его фразы на кантонском. Вова попытался общаться с ними на мандаринском диалекте, но и тут его постигла неудача.
 * Тогда Вова решил узнать больше о диалектах китайского языка. Оказалось, что в Китае говорят на k различных диалектах, причём не менее a1 китайцев говорят на первом диалекте, не менее a2 китайцев — на втором диалекте, …, не менее ak китайцев — на k-м диалекте. Сколько минимум китайцев говорят на всех k диалектах, если население Китая составляет n человек?
 * Исходные данные
 * В первой строке записаны целые числа n и k (2 ≤ k ≤ 20; 1 ≤ n ≤ 109). Во второй строке через пробел записаны целые числа a1, …, ak (1 ≤ ak ≤ n).
 * Результат
 * Выведите минимальное количество жителей Китая, говорящих на всех k диалектах китайского языка.
 * Примеры
 * исходные данные	результат
 *
 * 1000000000 2
 * 800000000 800000000
 *
 *
 *
 * 600000000
 *
 * 1000000000 2
 * 500000000 500000000
 *
 *
 *
 * 0
 */
public class ChinaLanguage
{
    private static final BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(System.in));

    public static void main(String[] args) {
        int n = nextInt(), k = nextInt();
        int a = nextInt();

        while(--k > 0) {
            a = nextInt() + a;
            if(a <= n) {
                System.out.println(0);
                return;
            } else {
                a -= n;
            }
        }

        System.out.println(a);
    }

    private static int nextInt() {
        try {
            int c;
            do {
                c = reader.read();
            } while(c != -1 && (c < '0' || c > '9'));

            if(c == -1) {
                return -1;
            }

            int result = 0;
            do {
                result = result * 10 + (c - '0');
                c = reader.read();
            } while(c != -1 && c >= '0' && c <= '9');

            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
