package com.company.laba8;

import java.util.*;

public class example_25_07 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Вводите целые числа. Что бы закончить ввод - введите любой другой символ: ");
        int[] numbers = readInts(console);

        int[] evenNumbers = Arrays.stream(numbers).filter(number -> number % 2 == 0).toArray();
        System.out.printf(
                "Сумма %d, количество: %d, среднее значение: %.2f среди чётных чисел\n",
                Arrays.stream(evenNumbers).sum(),
                Arrays.stream(evenNumbers).count(),
                Arrays.stream(evenNumbers).average().getAsDouble()
        );

        int[] positiveEvenNumbers = Arrays.stream(evenNumbers).filter(number -> number >= 0).toArray();

        System.out.println("Все положительный чётные числа: ");
        for (int number: positiveEvenNumbers) {
            System.out.print(number + "\t");
        }
        System.out.println();


        int indexMin = getIndexByFunction(positiveEvenNumbers, (x,y) -> x < y);
        int indexMax = getIndexByFunction(positiveEvenNumbers, (x,y) -> x > y);
        positiveEvenNumbers[indexMin] += positiveEvenNumbers[indexMax];
        positiveEvenNumbers[indexMax] = positiveEvenNumbers[indexMin] - positiveEvenNumbers[indexMax];
        positiveEvenNumbers[indexMin] = positiveEvenNumbers[indexMin] - positiveEvenNumbers[indexMax];

        System.out.println("Переставлены местами минимальное и максимальное значение среди предыдущих чисел: ");
        for (int number: positiveEvenNumbers) {
            System.out.print(number + "\t");
        }
        System.out.println();
    }

    private static int[] readInts(Scanner scanner) {
        List<Integer> buffer = new ArrayList<>();
        System.out.print("> ");
        while(scanner.hasNextInt()) {
            buffer.add(Integer.valueOf(scanner.nextLine()));
            System.out.print("> ");
        }

        int size = buffer.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = buffer.get(i);
        }
        return result;
    }

    private static int getIndexByFunction(int[] array, Comparation comp) {
        if(array.length < 2) {
            return array.length - 1;
        }

        int index = 0;
        for(int current = 1; current < array.length; current++) {
            if(comp.compare(array[index], array[current])) {
                index = current;
            }
        }

         return index;
    }
}
