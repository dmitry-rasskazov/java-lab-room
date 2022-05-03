package com.company.laba10;

public class example_25_02 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new RuntimeException("Непроверяемая ошибка"); // генерация исключения
        } catch (Exception e) { // перехват сгенерированного исключения перехвадчиком предка
            System.out.println("2 "+ e );
        }
        System.out.println("3");
    }
}
