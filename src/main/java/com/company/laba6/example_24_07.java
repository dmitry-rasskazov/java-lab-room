package com.company.laba6;

public class example_24_07 {
    public static int[] getSymbolCodes(char[] source) {
        int size = source.length;

        int[] target = new int[size];
        for(int i = 0; i < size; i++) {
            target[i] = source[i];
        }

        return target;
    }

    public static void main(String[] args) {
        char[] numbers = "Hello world!".toCharArray();

        System.out.println("Имеется массив символов: ");
        for(char number: numbers) {
            System.out.print("\t" + number);
        }
        System.out.println("\nЭтим символам соответствуют коды: ");

        for(int number: getSymbolCodes(numbers)) {
            System.out.print("\t" + number);
        }
    }
}
