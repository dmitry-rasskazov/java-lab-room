package com.company.laba6;

public class example_24_01 {
    public static void main(String[] args) {
        Example01Class testClass1 = new Example01Class();
        Example01Class testClass2 = new Example01Class();

        testClass1.set('A');
        testClass1.set("New text");

        testClass2.set(new char[]{'A'});
        testClass2.set(new char[]{'N', 'e', 'w', ' ', 't', 'e', 'x', 't'});

        if(testClass1.text().equals(testClass2.text())) {
            System.out.println("Строки, записанные путём передачи массива и строки в перегруженный метод, эквивалентны.");
        } else {
            System.out.println("Строки не эквивалентны!");
        }

        if(testClass1.symbol() == testClass2.symbol()) {
            System.out.println("Символы, записанные путём передачи массива и строки в перегруженный метод, равны.");
        } else {
            System.out.println("Символы не равны!");
        }
    }
}
