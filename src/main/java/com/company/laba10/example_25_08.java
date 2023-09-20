package com.company.laba10;

public class example_25_08 {
    public static int m(){ // метод, в котором обрабатывается исключительная ситуация
        try {
            System.out.println("0");
            throw new RuntimeException(); // генерация исключения
        } finally {
            System.out.println("1"); // выведет в это число, так как finally выполняется всегда
        }
    }
    public static void main(String[] args) {
        System.out.println(m());
    }
}
