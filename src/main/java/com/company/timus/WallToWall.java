package com.company.timus;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

/**
 * 2025. Стенка на стенку
 * Ограничение времени: 1.0 секунды
 * Ограничение памяти: 64 МБ
 * Бокс, каратэ, самбо… Классические боевые единоборства пресытили аудиторию. Поэтому известный спортивный канал запускает новый формат соревнований, основанный на традиционной русской забаве — боях стенка на стенку. В соревновании могут участвовать от двух до k команд, каждая из которых будет соперничать с остальными. Всего в соревновании примут участие n бойцов. Перед началом боя они должны разделиться на команды, каждый боец должен войти ровно в одну команду. За время боя два бойца сразятся, если они состоят в разных командах. Организаторы считают, что популярность соревнований будет тем выше, чем больше будет количество схваток между бойцами. Помогите распределить бойцов по командам так, чтобы максимизировать количество схваток между бойцами, и выведите это количество.
 * Исходные данные
 * В первой строке дано количество тестов T (1 ≤ T ≤ 10). В следующих T строках перечислены тесты. В каждой из них записаны целые числа n и k через пробел (2 ≤ k ≤ n ≤ 104).
 * Результат
 * Для каждого теста в отдельной строке выведите одно целое число — ответ на задачу.
 * Пример
 * исходные данные	результат
 *
 * 3
 * 6 3
 * 5 5
 * 4 2
 *
 *
 *
 * 12
 * 10
 * 4
 */
public class WallToWall
{
    private static final StreamTokenizer tokenizer = new StreamTokenizer(new java.io.InputStreamReader(System.in));
    private static final PrintWriter writer = new PrintWriter(System.out);

    public static void main(String[] args) {
        int T = nextInt();
        int n, k, teammates, leftovers;
        long groupA, groupB, result;

        for(int i = 0; i < T; i++) {
            n = nextInt();
            k = nextInt();
            teammates = n / k;
            leftovers = n % k;
            k -= leftovers;
            groupA = combinations(k) * teammates * teammates;
            groupB = combinations(leftovers) * (teammates + 1) * (teammates + 1);

            result = groupA + groupB + ((long) k * teammates * leftovers * (teammates + 1));

            writer.println(result);
        }

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

    private static long combinations(int n) {
        if(2 > n) {
            return 0L;
        }

        long numerator = 1L;

        numerator *= n;
        numerator *= n - 1;

        return numerator / 2;
    }
}
