package com.company.laba6;

public class example_24_03 {
    public static void main(String[] args) {
        int[] numbers = {1, 10, 15, 2, 0, 7, 9, 13, 46, 28};

        System.out.println("Имеется ряд чисел: ");
        for(int number: numbers) {
            System.out.print("\t" + number);
        }
        System.out.println();

        System.out.printf("Максимальное из введённых значений: %d\n", AggregateFunctions.max(numbers));
        System.out.printf("Минимальное из введённых значений: %d\n", AggregateFunctions.min(numbers));
        System.out.printf("Среднее (медианное) из чисел последовательности: %d\n", AggregateFunctions.median(numbers));
    }
}
