package com.company.laba6;

public class example_24_08 {
    public static float avg(int[] source) {
        float result = 0;

        for(int item: source) {
            result += item;
        }

        return result / 2;
    }

    public static void main(String[] args) {
        int[] numbers = {1,11,12,20,14,1,8,52,32,45,74,23,2,5,4,8,6,5,8,52};

        System.out.println("Имеется ряд чисел: ");
        for(int number: numbers) {
            System.out.print("\t" + number);
        }

        System.out.printf("\nСреднее арифметическое для них составляет: %.2f", avg(numbers));
    }
}
