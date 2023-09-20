package com.company.timus;

import java.io.IOException;

public class SinusDance
{
    public static void main(String[] args)
    {
        int N = nextInt();

        String result = "";

        for(int i = 1, j = N; i <= N; i++, j--)
        {
            if(1 == i) {
                result = String.format("%s+%d", generateSin(i), j);
            } else {
                result = String.format("(%s)%s+%d", result, generateSin(i), j);
            }
        }

        System.out.println(result);
    }

    private static int nextInt()
    {
        int result = 0;
        int buf;
        boolean captured = false;

        try {
            while ((buf = System.in.read()) != -1) {
                if(buf >= '0' && buf <= '9') {
                    captured = true;
                    result = ((result * 10) + (buf - '0'));
                } else if(captured && (buf == ' ' || buf == '\n')) {
                    break;
                }
            }
        } catch (IOException exception) {
            return -1;
        }

        return result;
    }

    private static String generateSin(int target)
    {
        return generateSin(1, target);
    }

    private static String generateSin(int depth, int target)
    {
        if(1 > depth || 1 > target || depth > target) {
            return null;
        }

        if(target == depth) {
            return String.format("sin(%d)", target);
        }

        return String.format("sin(%d%s%s)", depth, (depth & 1) == 0 ? "+" : "-", generateSin(depth+1, target));
    }
}

/**
 * 1149. Танцы синуса
 * Ограничение времени: 1.0 секунды
 * Ограничение памяти: 64 МБ
 * Пусть An = sin(1–sin(2+sin(3–sin(4+…sin(n))…)
 * Обозначим Sn = (…(A1+n)A2+n–1)A3+…+2)An+1
 * Для заданного N выведите выражение SN
 * Исходные данные
 * В единственной строке дано целое число N. 1 ≤ N ≤ 200
 * Результат
 * Выведите строку SN
 * Пример
 * исходные данные	результат
 *
 * 3
 *
 *
 *
 * ((sin(1)+3)sin(1–sin(2))+2)sin(1–sin(2+sin(3)))+1
 */
