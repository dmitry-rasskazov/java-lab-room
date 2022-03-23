package com.company.laba4;

import java.util.Scanner;

public class example_24_08 {
    private static final int A_CODE = 'A';
    private static final int Z_CODE = 'Z';
    private static final int a_CODE = 'a';
    private static final int z_CODE = 'z';

    private static int key = 0;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.println("Введите текст для шифрования: ");
        String text = console.nextLine();

        System.out.println("Введите ключ шифрования: ");
        int newKey = console.nextInt() % (Z_CODE - A_CODE + z_CODE - a_CODE); // Получаем действительный сдвиг алфавита в его пределах
        key = 0 > newKey ? (Z_CODE - A_CODE) + newKey : newKey; // привожу отрицательный ключь к эквивалентному в контексте преобразования положительному ключу

        char[] newText = new char[text.length()];

        for(int i = 0; i < text.length(); i++) {
            newText[i] = getSymbol(text.charAt(i));
        }

        System.out.printf("Текст после преобразования: %s\n\n", String.valueOf(newText));
        char response;
        boolean isValidResponse;

        do{
            System.out.println("Выполнить обратное преобразование? (y/n): ");

            response = console.next().charAt(0);
            isValidResponse = response == 'y' || response == 'n';

            if(!isValidResponse) {
                System.out.println("Введите корректный ответ");
            }
        }while(!isValidResponse);

        if(response == 'y') {
            System.out.println(text);
        } else {
            System.out.println("До свидания!");
        }
    }

    private static char getSymbol(char current) {
        int result = current;
        int diff, next = current+key;

        if(current >= A_CODE && current <= Z_CODE) {
            diff = Z_CODE - next;
            result = diff >= 0 ? next : a_CODE - diff;
        } else if(current >= a_CODE && current <= z_CODE) {
            diff = z_CODE - next;
            result = diff >= 0 ? next : A_CODE - diff;
        }

        return (char) result;
    }
}
