package com.company.laba10;

public class example_25_14 {
    public static void m(int x) throws ArithmeticException{ // Для корректной работы программы нужно сообщить вызывающему коду какой тип исключения возникает в процессе работы метода
        int h=10/x;
    }
    public static void main(String[] args) {
        try {
            int l = args.length;
            System.out.println("размер массива= " + l);
            m(l);
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: Деление на ноль");
        }
    }
}
