package com.company.laba3;

public class example_24_08 {
    public static void main(String[] args) {
        final int literA = 65; // десятичный код символа 'A' в unicode

        char[] targetArray = new char[10];

        for (int count = 0, i = 0; count < 10; i++) {
            char liter = (char) (literA+i);

            if(liter != 'A' && liter != 'E' && liter != 'I') {
                targetArray[count] = liter;
                count++;
            }
        }

        System.out.println("Список первые 10 согласных: ");

        for(char x:targetArray) {
            System.out.println(x);
        }
    }
}
