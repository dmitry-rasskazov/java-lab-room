package com.company.timus;

import java.io.IOException;

public class Scholarship {
    public static void main(String[] args) throws IOException {
        short N = nextInt();
        short res = 0;

        for (short i = 0; i < N; i++) {
            short grade = nextInt();
            if(grade == 3) {
                System.out.println("None");
                return;
            }
            res += grade;
        }

        float mean = (float) res / N;

        if(mean >= 5) {
            System.out.println("Named");
        } else if(mean >= 4.5) {
            System.out.println("High");
        } else {
            System.out.println("Common");
        }
    }

    private static short nextInt() throws IOException {
        short result = 0;
        short buf;
        boolean captured = false;
        while ((buf = (short) System.in.read()) != -1) {
            if(buf >= '0' && buf <= '9') {
                captured = true;
                result = (short) ((result * 10) + (buf - '0'));
            } else if(captured && (buf == ' ' || buf == '\n')) {
                break;
            }
        }

        return result;
    }
}


/**
 * 2056. Стипендия
 * Ограничение времени: 1.0 секунды
 * Ограничение памяти: 64 МБ
 * Вот и подошел к концу первый семестр в университете. Андроид Вася успешно сдал все экзамены и теперь хочет узнать, будет ли у него стипендия. В университете следующая политика предоставления стипендии.
 *
 *     Если у студента есть тройки, то стипендия ему не выплачивается.
 *     Если студент сдал сессию на одни пятерки, то он получает именную стипендию.
 *     Если студент не получил именную стипендию, и его средний балл не менее 4.5, то он получает повышенную стипендию.
 *     Если студент не получил ни именную, ни повышенную стипендии, и при этом у него нет троек, то он получает обычную стипендию.
 *
 * Помогите Васе определить, будет ли у него стипендия, и если да, то какая.
 * Исходные данные
 * В первой строке записано целое число n — количество экзаменов (1 ≤ n ≤ 10). В i-й из следующих n строк записано целое число mi — оценка, полученная Васей на i-м экзамене (3 ≤ mi ≤ 5).
 * Результат
 * Если у Васи не будет стипендии, выведите «None». Если у него будет обычная стипендия, выведите «Common», если повышенная — «High», если именнная — «Named».
 */