package com.company.laba6;

public class example_24_09 {
    public static void printRemixedArray(int[] source) {
        int size = source.length;

        System.out.println("\nЗеркальный массив: ");
        for(int i = size-1; i >= 0; --i) {
            System.out.print("\t" + source[i]);
        }
    }

    public static void main(String[] args) {
        int[] numbers = {1,11,12,20,14,1,8,52,32,45,74,23,2,5,4,8,6,5,8,52};

        System.out.println("Имеется ряд чисел: ");
        for(int number: numbers) {
            System.out.print("\t" + number);
        }

        printRemixedArray(numbers);
    }
}
