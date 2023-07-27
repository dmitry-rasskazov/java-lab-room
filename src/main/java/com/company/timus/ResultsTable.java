package com.company.timus;

import java.io.*;

public class ResultsTable {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1024);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out), 1024);

        int N = nextInt();
        int[][] results = new int[N][2];

        for (int i = 0; i < N; i++) {
            results[i][0] = nextInt();
            results[i][1] = nextInt();
        }

        mergeUSort(results);

        for (int i = 0; i < N; i++) {
            bw.write(String.format("%d %d", results[i][0], results[i][1]));
            bw.newLine();
        }
        bw.flush();
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

    private static void mergeUSort(int[][] source)
    {
        mergeUSort(source, new int[source.length][2], 0, source.length-1);
    }

    private static void mergeUSort(int[][] source, int[][] buff, int left, int right)
    {
        if(left >= right) {
            overrideValue(source, left, buff, left);
            return;
        }

        int median = (right + left) / 2;
        mergeUSort(source, buff, left, median);
        mergeUSort(source, buff, median+1, right);

        for(int i = left, j = median+1, u = left;;)
        {
            if(i <= median && j <= right) {
                if(source[i][1] >= source[j][1]) {
                    overrideValue(source, i, buff, u);
                    i++;
                } else {
                    overrideValue(source, j, buff, u);
                    j++;
                }
            } else if(i <= median) {
                overrideValue(source, i, buff, u);
                i++;
            } else if(j <= right) {
                overrideValue(source, j, buff, u);
                j++;
            } else {
                break;
            }

            u++;
        }

        for(int i = left; i <= right; i++) {
            overrideValue(buff, i, source, i);
        }
    }

    private static void overrideValue(int[][] source, int sourceIndex, int[][] target, int targetIndex)
    {
        target[targetIndex][0] = source[sourceIndex][0];
        target[targetIndex][1] = source[sourceIndex][1];
    }
}

/**
 * 1100. Таблица результатов
 * Ограничение времени: 1.0 секунды
 * Ограничение памяти: 16 МБ
 * Старое программное обеспечение для проведения соревнований использует пузырьковую сортировку для создания таблицы результатов. Однако сейчас команд слишком много, и программное обеспечение работает слишком медленно. Вас попросили написать программу, которая создаёт такую же таблицу результатов, как и старое программное обеспечение, но быстро.
 * Исходные данные
 * Первая строка входных данных содержит только целое число 1 < N ≤ 150 000 — количество команд. Каждая из следующих N строк содержит два целых числа: 1 ≤ ID ≤ 107 и 0 ≤ M ≤ 100. ID — уникальный номер команды, а M — количество решённых этой командой задач.
 * Результат
 * Вывод должен содержать N строк с двумя целыми числами ID и M в каждой. Строки должны идти по убыванию M в порядке, полученном с помощью пузырьковой сортировки (см. ниже).
 */