package com.company.example;

import java.util.*;

public class ArrayExample {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        List<Integer> list = new ArrayList<Integer>();

        System.out.print("Введите с клавиатуры число: ");
        String word;

        try {
            while (!(word = console.nextLine()).equals("")) {
                list.add(Integer.parseInt(word));
            }
        } catch (NoSuchElementException exception) {
            System.out.println("Ввод закончен. Результат: ");
        } catch (NumberFormatException exception) {
            System.out.println("Ошибка ввода: попалось незнакомое число. Результат: ");
        }

        Collections.shuffle(list);

        Integer test;

        for (Integer num: list) {
            System.out.println(num);
        }
    }
}
