package com.company.laba10;

public class example_25_01 {
    public static void main(String[] args) {
        try { // объявлен блок кода, внутри которого могут возникнуть исключительные ситуации
            System.out.println("0"); // вывод символа "0" в первой строке
            throw new RuntimeException("Непроверяемая ошибка"); // исключение сгенерировано с текстом ошибки "Непроверяемая ошибка"
        } catch (RuntimeException e) { // исключение перехвачено
            System.out.println("1 "+ e); // исключение обработано
        }
        System.out.println("2");
    }
}
