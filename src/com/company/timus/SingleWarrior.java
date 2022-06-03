package com.company.timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SingleWarrior {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(console.readLine());

        int[] results = new int[size];

        for(int i = 0; i < size; i++) {
            results[i] = getResult((char) console.read(), Integer.parseInt(console.readLine()));
        }

        for (int item: results) {
            System.out.println(item);
        }
    }

    private static int getResult(char c, int r) {
        if(c >= 'c' && c <= 'f') {
            if(r >= 3 && r <= 6) {
                return 8;
            }

            if(r == 2 || r == 7) {
                return 6;
            }

            if(r == 1 || r == 8) {
                return 4;
            }
        }

        if(c == 'b' || c == 'g') {
            if(r >= 3 && r <= 6) {
                return 6;
            }

            if(r == 2 || r == 7) {
                return 4;
            }

            if(r == 1 || r == 8) {
                return 3;
            }
        }

        if(c == 'a' || c == 'h') {
            if(r >= 3 && r <= 6) {
                return 4;
            }

            if(r == 2 || r == 7) {
                return 3;
            }

            if(r == 1 || r == 8) {
                return 2;
            }
        }

        return 0;
    }
}


/**
 * 1197. Один в поле воин
 * Ограничение времени: 1.0 секунды
 * Ограничение памяти: 64 МБ
 * Условие этой задачи очень простое: вам всего лишь надо определить, сколько клеток находится под боем шахматного коня, одиноко стоящего на шахматной доске. На всякий случай напомним, что конь ходит буквой «Г» — на две клетки по горизонтали или вертикали в любом направлении, и потом на одну клетку в направлении, перпендикулярном первоначальному.
 * Исходные данные
 * В первой строке находится единственное число N, 1 ≤ N ≤ 64 — количество тестов. В каждой из последующих N строк содержится очередной тест: два символа (маленькая латинская буква от 'a' до 'h' и цифра от 1 до 8) — стандартное шахматное обозначение клетки, на которой стоит конь. При этом буква обозначает вертикаль, а цифра — горизонталь.
 * Результат
 * Выведите N строк: в каждой из них должно находиться единственное число — количество клеток шахматной доски, находящихся под боем коня.
 */