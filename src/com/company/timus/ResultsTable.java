package com.company.timus;

import java.io.*;

public class ResultsTable {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 8192);

    public static void main(String[] args) throws IOException {
        int N = nextInt();
        int[][] results = new int[N][2];
        int[][] buff = new int[N][2];

        for (int i = 0; i < N; i++) {
            results[i][0] = nextInt();
            results[i][1] = nextInt();
        }

        results = mergeSort(results, buff, 0, 0);

        for (int i = 0; i < N; i++) {
            System.out.printf("%d %d\n", results[i][0], results[i][1]);
        }
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

    private static int[][] mergeSort(int[][] up, int[][] down, int left, int right)
    {
        if(left == right) {
            down[left] = up[left];
            return down;
        }

        int middle = left + (right - left) / 2;
        int[][] l_buff = mergeSort(up, down, left, middle);
        int[][] r_buff = mergeSort(up, down, middle + 1, right);

        int[][] target = l_buff == up ? down : up;
        int l_cur = left, r_cur = middle + 1;
        for(int i = left; i <= right; i++) {
            if (l_cur <= middle && r_cur <= right)
            {
                if (l_buff[l_cur][1] < r_buff[r_cur][1])
                {
                    target[i] = l_buff[l_cur];
                    l_cur++;
                }
                else
                {
                    target[i] = r_buff[r_cur];
                    r_cur++;
                }
            }
            else if (l_cur <= middle)
            {
                target[i] = l_buff[l_cur];
                l_cur++;
            }
            else
            {
                target[i] = r_buff[r_cur];
                r_cur++;
            }
        }

        return target;
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