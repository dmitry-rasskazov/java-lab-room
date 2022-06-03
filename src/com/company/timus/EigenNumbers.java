package com.company.timus;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

public class EigenNumbers {
    private static final InputStream console = System.in;

    public static void main(String[] args) throws IOException {
        Set<Integer> first = new HashSet<>();
        Set<Integer> second = new HashSet<>();
        Set<Integer> third = new HashSet<>();

        int a = nextInt();
        for(int i = 0; i < a; i++) {
            first.add(nextInt());
        }

        a = nextInt();
        for(int buf, i = 0; i < a; i++) {
            if(first.contains(buf = nextInt())) {
                second.add(buf);
            }
        }
        first.clear();

        a = nextInt();
        for(int buf, i = 0; i < a; i++) {
            if(second.contains(buf = nextInt())) {
                third.add(buf);
            }
        }
        System.out.println(third.size());
    }

    private static int nextInt() throws IOException {
        StringBuilder buffer = new StringBuilder();
        char c;
        int buf;
        while ((buf = console.read()) != -1 && (c = (char) buf) >= (int) '0' && c <= (int) '9') {
            buffer.append(c);
        }

        if(buffer.length() > 0) {
            return Integer.parseInt(buffer.toString());
        }

        return nextInt();
    }
}

/**
 * 1880. Собственные числа Psych Up
 * Ограничение времени: 0.5 секунды
 * Ограничение памяти: 64 МБ
 * Problem illustration
 * Шёл очередной контест Петрозаводских сборов. Игроки команды Psych Up быстро нашли простую задачу, и Федя сел за компьютер. Через пять минут решение было готово. Не тратя времени на тестирование, Федя отправил его на проверку и через несколько секунд получил вердикт Time Limit Exceeded.
 * Федя скомкал условие задачи и вышел из класса, хлопнув дверью. Что-то шло не так, нужно было развеяться. По пути в туалет он услышал разговор авторов контеста. Паша обсуждал со своим другом решение той самой задачи. Федя смог разобрать из их разговора только слова «собственные числа».
 * Федя подумал и решил, что у него, конечно же, есть собственные числа. Например, дата рождения, номер квартиры, оценка на последнем экзамене, количество поездок на соревнования. Но ведь контест командный. А что такое собственные числа команды? Естественно, что число является собственным для команды, если оно собственное для каждого из её участников. С такими радостными мыслями Федя направился назад в аудиторию.
 * Исходные данные
 * Входные данные состоят из трёх блоков по две строки. Первая строка каждого блока содержит целое число n —количество собственных чисел очередного игрока (1 ≤ n ≤ 4 000). Во второй строке блока записано n целых различных чисел в порядке возрастания — собственные числа очередного игрока. Все собственные числа — целые, положительные и не превосходят 109.
 * Результат
 * Выведите количество собственных чисел команды Psych Up.
 */
