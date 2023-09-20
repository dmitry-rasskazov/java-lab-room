package com.company.laba10;

import java.util.InputMismatchException;
import java.util.Scanner;

public class example_25_17 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        byte[] array = new byte[10];
        long sum = 0;
        String buffer;
        System.out.println("Введите 10 чисел в диапозоне от -128 до 127: ");
        for (int i = 0; i < 10; ) {
            try {
                buffer = console.nextLine();
                checkByte(buffer);
                array[i] = Byte.parseByte(buffer);
            } catch (NumberFormatException e) {
                System.out.println("Введённая строка не являеся числом.");
                continue;
            } catch (InputMismatchException e) {
                System.out.println("Число выходит за диапозон");
                continue;
            }
            i++;
        }

        System.out.print("Сумма введённых вами элементов: ");
        for (int i = 0; i < 10; i++) {
            sum += array[i];
        }
        System.out.println(sum);
    }

    private static void checkByte(String b) {
        int a = Integer.parseInt(b);
        if (a < -128 || a > 127) {
            throw new InputMismatchException("Число выходит за диапозон");
        }
    }
}
