package com.company.laba8;

public class example_25_06 {
    public static void main(String[] args) {
        int[] array = {1, 2, -5, 120, -850, 63, 54, 10};
        LinkedList list = LinkedList.createHead(array);
        System.out.println("Изначальный список, заполненный с головы:");
        System.out.println(list.toString());
        System.out.println();

        list.addLast(123);
        System.out.println("Добавили элемент в хвост списка: ");
        System.out.println(list.toString());
        System.out.println();

        list.addFirst(321);
        System.out.println("Добавили элемент в холову списка: ");
        System.out.println(list.toString());
        System.out.println();

        list.removeFirst();
        System.out.println("Удалили элемент из головы списка: ");
        System.out.println(list.toString());
        System.out.println();

        list.removeLast();
        System.out.println("Удалили элемент из хвоста списка: ");
        System.out.println(list.toString());
        System.out.println();

        list.insert(5, 521);
        System.out.println("Добавили элемент в позицию 5 список: ");
        System.out.println(list.toString());
        System.out.println();

        list.remove(5);
        System.out.println("Удалили зи позиции 5 элемент списка: ");
        System.out.println(list.toString());
        System.out.println();

        list = LinkedList.createHeadRec(array);
        System.out.println("Создали список рекурсивным методом, добавляя элементы с головы: ");
        System.out.println(list.toString());
        System.out.println();

        list = LinkedList.createTailRec(array);
        System.out.println("Создали список рекурсивным методом, добавляя элементы с хвоста: ");
        System.out.println(list.toString());
        System.out.println();

        System.out.println("Выводим строку списка, полученную рекурсивным методом: ");
        System.out.println(list.toStringRec());
        System.out.println();
    }
}
