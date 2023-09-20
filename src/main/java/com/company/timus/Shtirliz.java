package com.company.timus;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Shtirliz
{
    private static final InputStream iStream = new BufferedInputStream(System.in, 1024);

    public static void main(String[] args)
    {
        String encoded = nextWord();

        System.out.println(encoded);

    }

    private static String nextWord()
    {
        StringBuilder result = new StringBuilder();
        int buf, prev = -1, currentSize;
        boolean captured = false;

        try {
            while ((buf = System.in.read()) != -1) {
                if(buf >= 'a' && buf <= 'z' || buf >= 'A' && buf <= 'Z') {
                    captured = true;
                    if(prev == buf) {
                        result.deleteCharAt(result.length()-1);
                        currentSize = result.length()-1;
                        prev = 0 > currentSize ? -1 : result.charAt(currentSize);
                    } else {
                        result.append((char) buf);
                        prev = buf;
                    }
                } else if(captured && (buf == ' ' || buf == '\n')) {
                    break;
                }
            }
        } catch (IOException exception) {
            return "";
        }

        return result.toString();
    }
}

/**
 * 1654. Шифровка
 * Ограничение времени: 1.0 секунды
 * Ограничение памяти: 64 МБ
 * Мюллер много раз пытался поймать Штирлица с поличным, но тот всё время выкручивался. Как-то раз Штирлиц просматривал электронную почту. В это время незаметно вошел Мюллер и увидел, как у него на экране появился бессмысленный набор символов. «Шифровка», — подумал Мюллер. «UTF-8», — подумал Штирлиц.
 * Известно, что Штирлиц шифрует текст следующим образом:
 *
 *     Убирает все пробелы и знаки препинания.
 *     Заменяет все подряд идущие одинаковые буквы на одну такую букву.
 *     Многократно вставляет в произвольное место текста две одинаковых буквы.
 *
 * Попробуйте восстановить текст, каким он был после второго шага. Для этого удалите из текста все пары одинаковых символов, добавленные на третьем шаге.
 * Исходные данные
 * В единственной строке записана шифровка Штирлица, состоящая из строчных латинских букв. Длина шифровки не превосходит 200000.
 * Результат
 * Выведите восстановленный текст.
 * Пример
 * исходные данные	результат
 *
 * wwstdaadierfflitzzz
 *
 *
 *
 * stierlitz
 */