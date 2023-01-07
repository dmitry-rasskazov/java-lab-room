package com.company.timus;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Bayan
{
    private static final InputStream console = new BufferedInputStream(System.in, 512);

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(console);

        int N = scanner.nextInt();
        scanner.nextLine();
        int result = 0;
        Set<String> buff = new HashSet<>();
        String word;
        for(int i = 0; i < N; i++) {
            word = scanner.nextLine();
            if(buff.contains(word)) {
                result++;
                continue;
            }

            buff.add(word);
        }

        System.out.println(result);
    }
}

/**
 * 1563. Баяны
 * Ограничение времени: 1.0 секунды
 * Ограничение памяти: 64 МБ
 * Problem illustration
 * Как известно, в небоскрёбах часто располагаются магазины, в которые ходят гламурные модницы. Любимое занятие блондинки Анжелы — шоппинг. И сегодня у нее праздник — поход за покупками в новый небоскрёб Призма. Для начала она решила обойти там все магазины. Но, как оказалось, Призма настолько большая, что в ней встречаются магазины разных фирм по нескольку раз. Каждый раз, когда Анжела видела магазин той же фирмы, что она уже посетила, то произносила: «БАЯН», — и шла дальше.
 * Сколько раз Анжела сказала «БАЯН», пока обходила все магазины?
 * Исходные данные
 * В первой строке записано целое число N — количество магазинов в Призме (1 ≤ N ≤ 1000). В каждой из следующих N строк записано название магазина — строка из латинских букв и пробелов длиной от 1 до 30. Известно, что в Призме нет магазинов, названия которых отличаются только регистром.
 * Результат
 * Выведите количество магазинов, которые не посетила Анжела.
 * Пример
 * исходные данные	результат
 *
 * 12
 * ESPRIT
 * Nice Connection
 * Camelot
 * Adilisik
 * Lady and Gentleman City
 * MEXX
 * Camelot
 * Sultanna Frantsuzova
 * Camaieu
 * MEXX
 * Axara
 * Camelot
 *
 *
 *
 * 3
 */
