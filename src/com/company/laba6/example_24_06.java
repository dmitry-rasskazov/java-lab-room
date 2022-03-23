package com.company.laba6;

import java.util.Scanner;

public class example_24_06 {
    public static int[] getSubArray(int[] source, int size) {
        size = Math.min(size, source.length);

        int[] target = new int[size];
        for(int i = 0; i < size; i++) {
            target[i] = source[i];
        }

        return target;
    }

    public static void main(String[] args) {
        int[] numbers = {1,11,12,20,14,1,8,52,32,45,74,23,2,5,4,8,6,5,8,52};

        System.out.println("Имеется ряд чисел: ");
        for(int number: numbers) {
            System.out.print("\t" + number);
        }
        System.out.println("\nВведите число элементов, попадающих в целевой массив: ");
        Scanner console = new Scanner(System.in);

        for(int number: getSubArray(numbers, console.nextInt())) {
            System.out.print("\t" + number);
        }
    }
}
