package com.company.timus;

import java.io.IOException;

public class Pherma
{
    public static void main(String[] args) throws IOException {
        int N = System.in.read() - '0';
        /* Because Timus generates 2 bytes for a finish of stream */
        if(System.in.available() == 2) {
            char[] res;
            if(N == 1) {
                res = new char[]{'1', ' ', '2', ' ', '3'};
            } else if(N == 2) {
                res = new char[]{'3', ' ', '4', ' ', '5'};
            } else {
                res = new char[]{'-', '1'};
            }
            System.out.print(res);
        } else {
            System.out.print(-1);
        }
    }
}

/**
 * 1349. Ферма
 * Ограничение времени: 1.0 секунды
 * Ограничение памяти: 64 МБ
 * Стоит себе ферма. На ферме сидит фермер и считает, сколько кого есть у него на ферме - a верблюдов, b баранов, с зеленых тараканов. Почему-то an + bn = cn. Известно n. Найти все остальное.
 * Исходные данные
 * n (0 ≤ n ≤ 100)
 * Результат
 * Три различных целых числа (а, b, c) таких, что аn + bn = cn, 1 ≤ a, b, c ≤ 100. Если решений несколько, вывести то, где a минимально. Если и таких несколько, вывести то, где минимально b и т.д. Вывести −1, если решения нет.
 * Примеры
 * исходные данные	результат
 *
 * 0
 *
 *
 *
 * -1
 *
 * 1
 *
 *
 *
 * 1 2 3
 */