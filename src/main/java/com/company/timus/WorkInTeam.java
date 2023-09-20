package com.company.timus;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class WorkInTeam {
    private static final BufferedInputStream console = new BufferedInputStream(System.in, 8192);

    public static void main(String[] args) throws IOException {
        int N = nextInt();
        List<Integer> res = new LinkedList<>();
        PrintWriter print = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out), 16384));

        int current = 0, count = 0, buf = nextInt();
        for (int i = 0; i < N; i++) {
            if(i == 0) {
                current = buf;
            } else {
                buf = nextInt();
            }

            if(buf != current) {
                res.add(count);
                res.add(current);
                count = 1;
                current = buf;
            } else {
                count++;
            }
        }

        res.add(count);
        res.add(current);
        for (int i = 0, max = res.size(); i < max; i++) {
            if(i == 0) {
                print.print(res.get(i));
            } else {
                print.print(" " + res.get(i));
            }
        }
        print.flush();
    }

    private static int nextInt() throws IOException {
        int result = 0;
        int buf;
        boolean captured = false;
        while ((buf = console.read()) != -1) {
            if(buf >= '0' && buf <= '9') {
                captured = true;
                result = (result * 10) + (buf - '0');
            } else if(captured && (buf == ' ' || buf == '\n')) {
                break;
            }
        }

        return result;
    }
}


/**
 * 1581. Работа в команде
 * Ограничение времени: 1.0 секунды
 * Ограничение памяти: 64 МБ
 * Вася и Петя решили принять участие в командной олимпиаде по информатике. Но они слушали рассказы ветеранов спортивного программирования, а поэтому знали, что, помимо умения хорошо программировать, очень важна сыгранность участников. Поэтому они решили отрабатывать навыки работы в команде.
 * Вася написал на бумажке последовательность натуральных чисел и стал диктовать её Пете. Причём, для краткости, он диктует её так: сначала говорит количество подряд идущих одинаковых чисел, а затем говорит, что это за числа. Например, последовательность «1 1 2 3 3 3 10 10» он продиктует как «две единицы, одна двойка, три тройки, две десятки». Петя же, тоже для краткости, записывает вместо слов числа, которые говорит Вася. В указанном примере Петя запишет на бумажку: «2 1 1 2 3 3 2 10».
 * Отработав этот навык, друзья решили ещё потренироваться в программировании и научить компьютер преобразовывать последовательность Васи в последовательность Пети.
 * Исходные данные
 * В первой строке находится целое число N — количество чисел, записанных Васей (1 ≤ N ≤ 1000). Во второй строке через пробел записаны эти числа. Все числа целые, положительные и не превосходят 10.
 * Результат
 * В единственной строке выведите через пробел числа, которые должен был бы записать на бумажке Петя.
 * Пример
 * исходные данные	результат
 *
 * 8
 * 1 1 2 3 3 3 10 10
 *
 *
 *
 * 2 1 1 2 3 3 2 10
 */