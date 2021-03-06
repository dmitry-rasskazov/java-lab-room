package com.company.timus;

import java.util.Scanner;

public class DillContainer {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] first = new String[console.nextInt()];
        String[] second = new String[console.nextInt()];
        int j = 1;

        for(int i = 0; i < first.length; i++, j++) {
            first[i] = String.valueOf(j);
        }

        for(int i = 0, g = j+1; i < second.length; i++, g += j+1) {
            second[i] = String.valueOf(g);

        }

        System.out.println(String.join(" ", first));
        System.out.println(String.join(" ", second));
    }
}

/**
 * 1731. Укроп
 * Ограничение времени: 0.5 секунды
 * Ограничение памяти: 64 МБ
 * Иван Васильевич — заядлый дачник. До него дошли слухи о пользе и красоте укропа, поэтому весной он засеял весь участок двумя сортами этого растения.
 * Когда укроп вырос, Иван Васильевич заготовил n ящиков укропа первого сорта и m ящиков укропа второго сорта. Масса каждого ящика выражена целым числом килограммов, причём массы всех ящиков различны. Чтобы порадовать своих соседей — Ивана Ивановича и Ивана Никифоровича, Иван Васильевич решил подарить каждому из них по ящику укропа каждого сорта. Чтобы Иван Иванович не поссорился с Иваном Никифоровичем, суммарные массы двух ящиков, подаренных каждому из соседей, должны совпадать. Перебрав все возможные варианты, Иван Васильевич понял, что это сделать невозможно. Определите массы ящиков с укропом, заготовленных Иваном Васильевичем.
 * Исходные данные
 * В единственной строке через пробел записаны целые числа n и m (2 ≤ n, m ≤ 50).
 * Результат
 * В первой строке выведите через пробел n чисел — массы ящиков с первым сортом укропа. Во второй строке выведите через пробел m чисел — массы ящиков со вторым сортом укропа. Массы должны быть положительными целыми числами, не превосходящими 109. Кроме того, все массы должны быть различными. Если задача имеет несколько решений, выведите любое из них. Если задача не имеет решения, выведите строку «It is a lie!».
 */


