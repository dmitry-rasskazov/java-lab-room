package com.company.laba10;

public class example_25_04 {
    public static void main(String[] args) {
        try { // объявлен блок, в котором могут быть сгенерированы исключения
            System.out.println("0");
            throw new RuntimeException("ошибка"); // генерация исключения
        } catch (NullPointerException e) { // блок перезвата неподходящего исключения
            System.out.println("1" );
        }catch (Exception e) { // блок перезвата подходящего предка исключения
            System.out.println("2" );
        }catch (Error e) { // блок перезвата неподходящего исключения
            System.out.println("3" );
        }
        System.out.println("4");
    }
}
