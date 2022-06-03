package com.company.timus;

import java.io.IOException;
import java.io.InputStream;

public class DiagonalScan {
    private static final InputStream console = System.in;

    public static void main(String[] args) throws IOException {
        int N = nextInt();
        int[][] matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = nextInt();
            }
        }
        int iterator = 0;
        String[] res = new String[N*N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < i+1; j++) {
                res[iterator] = String.valueOf(matrix[i - j][j]);
                iterator++;
            }
        }

        for(int i = 1; i < N; i++) {
            for(int j = N-1; j >= i; j--) {
                res[iterator] = String.valueOf(matrix[j][i+N-(j+1)]);
                iterator++;
            }
        }

        System.out.println(String.join(" ", res));
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
 * 1313. К вопросу о спорте
 * Ограничение времени: 0.5 секунды
 * Ограничение памяти: 64 МБ
 * Уральские медики очень озабочены состоянием здоровья молодежи. Как показали исследования, многие талантливые студенты вместо того, чтобы играть в футбол, кататься на коньках или велосипедах, занимаются олимпиадами по программированию. Так они это еще и спортивным программированием называют! Ну какой же это спорт, сидеть перед монитором и думать по пять часов в день! И ладно бы только на соревнованиях два раз в год, так ведь при подготовке к очередному чемпионату у них на сидение за компьютером уходит по несколько дней в неделю! И пусть бы это были разгильдяи какие-то, так ведь лучшие студенты, говорят, что и на мировом уровне результаты показывают приличные — жалко молодежь!
 * Чтобы отучить студентов от вредной привычки часами сидеть у компьютеров, уральские медики придумали принципиально новую разработку — монитор с диагональной разверткой! В скором будущем его будут вручать победителям и призерам чемпионатов Урала. В специально разработанном квадратном мониторе электронный луч должен проходить экран не по горизонталям, а по диагоналям. Поскольку длины диагоналей разные, нестандартные параметры мерцания и нелинейные искажения изображения быстро отучат оболтусов пялиться в экран. Разумеется, им ничего не останется делать, кроме как идти и заниматься спортом. Проблема в том, что большинство видеокарт подают на вход монитору нормальную развертку. Для успешного внедрения нового типа монитора нужна программа-адаптер, которая преобразует квадратное изображение в формат, требуемый для ввода в квадратный монитор. Программа должна быть надежной и быстрой, поэтому её разработкой будут заниматься самые лучшие программисты — участники чемпионата Урала по спортивному программированию.
 * Исходные данные
 * В первой строке записано целое число N (1 ≤ N ≤ 100) — количество пикселей на стороне квадратного монитора. Далее идут N строк, в каждой по N целых чисел в пределах от 1 до 100, разделенных пробелом. Это изображение, которое выводит обычная видеокарта (как видно, глубина цветности у нового монитора небольшая, все равно нормальному программисту больше ста цветов и не надо).
 * Результат
 * На выходе преобразователя должна получиться последовательность для ввода в новый монитор. Пиксели нумеруются от левого верхнего угла, по диагоналям, слева-направо и снизу-вверх. Подробнее объяснять тут долго и неинтересно, посмотрите на пример, дальше сами догадаетесь.
 */