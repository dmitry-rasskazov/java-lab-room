package com.company.laba3;

import java.util.Random; // пакет для подключения класса Random и создания объекта для генерации случайного числа
import java.util.Scanner; // пакет для подключения класса Scanner, для считывания с консоли значения

public class example_24_09 {
    public static void main(String[] args) {
        Scanner id = new Scanner(System.in); // Создание объекта класса Scanner для считывания числа введённого к консоль
        System.out.println("Введите размер массива"); // Сообщение пользователю "для красоты и понимания"
        int Size = id.nextInt(); // Запись в переменную Size (нужная для того чтобы задать размер массива)
        //значения введенного в консоль
        System.out.println("Размер массива равен " + Size); // Сообщение пользователю "для красоты и понимания"
        int[] nums = new int[Size]; // Создание массива с размером введённым из консоли
        Random random = new Random(); // Создание объекта класса Random для генерации "случайного" числа
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(200); // Присвоение i-тому элементу массива случайного значения
            System.out.println("Элемент массива [" + i + "] = " + nums[i]); // Сообщение пользователю "для красоты и понимания"
        }

        int minElement = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < minElement) {
                minElement = nums[i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == minElement) {
                System.out.printf("\nМинимальный элемент nums[%d] = %d%s", i, nums[i], "\n");
            }
        }

    }
}
