package com.company.timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BattleAtSwamp {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1024);

    public static void main(String[] args) throws IOException {
        int N = nextInt();
        int K = nextInt();

        int n = 0;
        int m = 0;

        for (int i = 0; i < N; i++) {
            int current = nextInt();
            if(current < K) {
                m += K - current;
            } else if(current > K) {
                n += current - K;
            }
        }

        System.out.printf("%d %d\n", n, m);
    }

    private static int nextInt() throws IOException {
        int result = 0;
        int buf;
        boolean captured = false;
        while ((buf = br.read()) != -1) {
            if(buf >= '0' && buf <= '9') {
                captured = true;
                result = ((result * 10) + (buf - '0'));
            } else if(captured && (buf == ' ' || buf == '\n')) {
                break;
            }
        }

        return result;
    }
}

/**
 * 1991. Битва у болота
 * Ограничение времени: 1.0 секунды
 * Ограничение памяти: 64 МБ
 * Гунган: Джа-Джа, кидай бум-бумы.
 * Джа-Джа: Что? Моя нет бум-бумы!
 * Гунган: На! Лови скорей!
 * В борьбе с Торговой Федерацией, королева Амидала решила обратиться за помощью к гунганам. Джа-Джа Бинкс провёл королеву и её людей в священное место, где и был заключён договор. Гунганы согласились выставить свою армию, чтобы помочь прогнать дроидов Федерации с территории столицы. В благодарность за объединение народов гунганский правитель Босс Нассом назначил Джа-Джа генералом.
 * И вот на берегу болота выстроились две армии. Дроиды Федерации, дисциплинированные солдаты, выстроены ровным строем и разделены на n блоков по k дроидов в каждом. У гунганов есть проверенное оружие против дроидов — небольшие энергетические шары, называемые бум-бумами. Один такой шар может вывести из строя ровно одного дроида.
 * Джа-Джа тоже решил разбить свою армию на n частей и дать каждой части задание на уничтожение соответствующего блока дроидов. Каждой части была выдана тележка с бум-бумами. Помогите теперь генералу Бинксу определить, сколько бум-бумов останется неиспользованными и сколько дроидов выживет после такой атаки. Вы можете считать, что бум-бум, пущенный гунганом в дроида, всегда находит свою цель.
 * Исходные данные
 * В первой строке входных данных находятся числа n и k (1 ≤ n, k ≤ 10 000). Во второй строке находятся n чисел ai (0 ≤ ai ≤ 100 000) — количество бум-бумов в i-й тележке.
 * Результат
 * Выведите два числа — количество неиспользованных бум-бумов и количество выживших дроидов.
 * Пример
 * исходные данные	результат
 *
 * 4 5
 * 2 7 5 0
 *
 *
 *
 * 2 8
 */