package com.company.timus;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

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
    private static final StreamTokenizer tokenizer = new StreamTokenizer(new java.io.BufferedReader(new java.io.InputStreamReader(System.in)));
    private static final PrintWriter writer = new PrintWriter(System.out);

    public static void main(String[] args) {
        int n = nextInt(), k = nextInt();
        int a = nextInt();

        while(--k > 0) {
            a = nextInt() + a;
            if(a <= n) {
                writer.println(0);
                writer.flush();
                return;
            } else {
                a -= n;
            }
        }

        writer.println(a);
        writer.flush();
    }

    private static int nextInt() {
        try {
            tokenizer.nextToken();
            return (int) tokenizer.nval;
        } catch (IOException ignored) {
            return -1;
        }
    }
}
