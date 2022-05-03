package com.company.laba10;

public class example_25_07 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new NullPointerException("ошибка");
        } catch (NullPointerException e) {
            System.out.println("1" );
            throw new ArithmeticException(); // Для этого исключения надо обернуть код ещё в обин блок перехвата
        } catch (ArithmeticException e) {
            System.out.println("2" );
        }
        System.out.println("3");

    }
}
