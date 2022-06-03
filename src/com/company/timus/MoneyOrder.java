package com.company.timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MoneyOrder {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(console.readLine());
        int[] array = new int[N];

        for(int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(console.readLine());
        }

        Arrays.sort(array);
        System.out.print(array[N/2]);
    }
}


/**
 * 1510. Порядок
 * Ограничение времени: 1.0 секунды
 * Ограничение памяти: 16 МБ
 * Новый русский Колян любит две вещи: деньги и порядок. У Коляна много денег, но в них нет порядка. Одним прекрасным утром Колян понял, что он больше не может это переносить, и решил навести порядок в своих деньгах. Он приказал своим верным помощникам извлечь деньги из подземного хранилища, и скоро его большая комната была заполнена красными, зелёными и синими банкнотами. Колян смотрел с отвращением на этот ужасный беспорядок. Сейчас он хочет оставить в своём хранилище банкноты только одного достоинства, а остальные деньги раздать бедным. Он точно знает, что более половины банкнот имеют одинаковое достоинство. Но в беспорядке невозможно понять, какая банкнота встречается чаще всего.
 * Исходные данные
 * Первая строка содержит количество банкнот Коляна N (1 ≤ N ≤ 500 000). В следующих N строках даны достоинства K этих банкнот (0 ≤ K ≤ 109). Более половины из этих значений одинаковы.
 * Результат
 * Выведите наиболее часто встречающееся достоинство банкнот.
 */