package com.company.timus;

import java.io.IOException;
import java.io.InputStream;

public class FourCrap {
    private static final InputStream console = System.in;

    public static void main(String[] args) throws IOException {
        int N = nextInt();
        if(N % 2 != 0) {
            N++;
        }

        if ((N >> 1) % 2 == 0) {
            System.out.print("black");
        } else {
            System.out.print("grimy");
        }
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
 * 1924. Четыре чертёнка
 * Ограничение времени: 1.0 секунды
 * Ограничение памяти: 64 МБ
 * Мир в опасности. Один известный мошенник по имени Остап умер, и, попав в ад, решил заключить сделку с дьяволом. Игра простая: четыре чертёнка делятся на две команды — «чёрные» и «чумазые» — и выходят на игровое поле. На игровом поле написаны в ряд числа от 1 до n, и игроки начинают по очереди ставить между ними чёрными чернилами знаки + или −. Задача «чёрных» — сделать так, чтобы после расстановки всех знаков результат стал чётным, а «чумазых» — чтобы результат стал нечётным. Все четыре чертёнка — профессионалы в этой игре, поэтому они всегда будут делать оптимальные ходы. «Чёрные» ходят первыми.
 * Условия сделки таковы: если Остап правильно угадает, какая команда выиграет, его пустят в рай. Если неправильно — дьявол получит власть над всем миром. Ставки велики, поэтому вам придётся помочь Остапу.
 * Исходные данные
 * На вход подаётся целое число n (1 ≤ n ≤ 50).
 * Результат
 * Если выиграют «чёрные», вывести «black», иначе вывести «grimy».
 */
