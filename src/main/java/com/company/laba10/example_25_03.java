package com.company.laba10;

public class example_25_03 {
    public static void main(String[] args) {
        try { // объявлен блок, в котором могут быть сгенерированы исключения
            System.out.println("0");
            throw new RuntimeException("ошибка"); // генерация исключения
        } catch (NullPointerException e) { // блок перезвата неподходящего исключения
            System.out.println("1" );
        }catch (RuntimeException e) { // блок перезвата подходящего исключения
            System.out.println("2" );
        }catch (Exception e) { // блок перезвата подходящего предка исключения
            System.out.println("3" );
        }
        System.out.println("4");
    }
}
