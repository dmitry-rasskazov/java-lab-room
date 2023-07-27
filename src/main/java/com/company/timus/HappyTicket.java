package com.company.timus;

import java.io.IOException;

public class HappyTicket {
    public static void main(String[] args) throws IOException {
        long num = nextInt();

        if(isHappy(num - 1) || isHappy(num + 1)) {
            System.out.print("Yes");
        } else {
            System.out.print("No");
        }
    }

    private static boolean isHappy(long number)
    {
        short[] parts = new short[6];

        split(number, parts);

        return parts[0] + parts[1] + parts[2] == parts[3] + parts[4] + parts[5];
    }

    private static void split(long number, short[] buff)
    {
        short part, i = 0;
        while(number > 0) {
            part = (short) (number % 10);
            number = (number - part) / 10;
            buff[i++] = part;
        }
    }

    private static long nextInt() throws IOException {
        long result = 0;
        short buf;
        boolean captured = false;
        while ((buf = (short) System.in.read()) != -1) {
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
 * 1493. В одном шаге от счастья
 * Ограничение времени: 1.0 секунды
 * Ограничение памяти: 64 МБ
 * Вова купил билет в трамвае 13-го маршрута и сразу посчитал суммы первых трёх цифр и последних трёх цифр номера билета (номер у билета шестизначный). Оказалось, что суммы отличаются ровно на единицу. «Я в одном шаге от счастья», — подумал Вова, — «или предыдущий или следующий билет точно счастливый». Прав ли он?
 * Исходные данные
 * В единственной строке записан номер билета. Номер состоит ровно из шести цифр, среди которых могут быть и нули. Гарантируется, что Вова умеет считать, то есть суммы первых трёх цифр и последних трёх цифр отличаются ровно на единицу.
 * Результат
 * Выведите «Yes», если Вова прав, и «No», если нет.
 * Примеры
 * исходные данные	результат
 *
 * 715068
 *
 *
 *
 * Yes
 *
 * 445219
 *
 *
 *
 * No
 *
 * 012200
 *
 *
 *
 * Yes
 */