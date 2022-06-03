package com.company.timus;

import java.util.Scanner;

public class SeriesSum {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int num = console.nextInt();
        long total = 0;

        if(num < 1) {
            for(int i = 1; i >= num; i--) {
                total += i;
            }
        } else {
            for(int i = 1; i <= num; i++) {
                total += i;
            }
        }

        System.out.println(total);
    }
}


/**
 * 1068. Сумма
 * Ограничение времени: 2.0 секунды
 * Ограничение памяти: 64 МБ
 * Всё, что от вас требуется — найти сумму всех целых чисел, лежащих между 1 и N включительно.
 * Исходные данные
 * В единственной строке расположено число N, по модулю не превосходящее 10000.
 * Результат
 * Выведите целое число — ответ задачи.
 */