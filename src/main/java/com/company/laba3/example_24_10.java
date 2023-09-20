package com.company.laba3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class example_24_10 {
    public static void main(String[] args) {
        Scanner consoleIn = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Введите размер массива:");
        int size = consoleIn.nextInt();

        int[] nums = new int[size];
        int[] target = new int[size];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(200); // Присвоение i-тому элементу массива случайного значения
            System.out.println("Элемент массива [" + i + "] = " + nums[i]); // Сообщение пользователю "для красоты и понимания"
        }

        Arrays.sort(nums);
        System.out.println("\nМассив в порядке убывания:");

        for (int i = nums.length-1, j = 0; i >= 0; i--, j++) {
            target[j] = nums[i];
        }

        for (int i = 0; i < target.length; i++) {
            System.out.print("\nЭлемент массива [" + i + "] = " + target[i]); // Сообщение пользователю "для красоты и понимания"
        }
    }
}
