package com.company.laba10;

public class example_25_10 {
    public static int m(){
        try {
            System.out.println("0");
            return 15;
        } finally {
            System.out.println("1");
            return 20; // переопределяет предыдущее возвращаемое значение
        } }
    public static void main(String[] args) {
        System.out.println(m());
    }
}
