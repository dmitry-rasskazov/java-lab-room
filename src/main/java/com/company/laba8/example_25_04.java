package com.company.laba8;

public class example_25_04 { // ГЛАВНЫЙ КЛАСС
    public static void main(String[] args) {
// создание несвязанных узлов с помощью конструктора
        LinkedListNode node0 = new LinkedListNode(0, null); // 0-й узел – будет головой в списке
        LinkedListNode node1 = new LinkedListNode(1, null);
        LinkedListNode node2 = new LinkedListNode(2, null);
        LinkedListNode node3 = new LinkedListNode(3, null); // последний узел – будет хвостом в списке
// связывание узлов в список с помощью ссылок
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
// вывод списка с использованием вспомогательной переменной ref,
// соответствующей текущему значению ссылки при прохождении по списку
        LinkedListNode ref = node0; // для перемещения по списку достаточно помнить голову
        while (ref != null) {
            System.out.print(" " + ref.value);
            ref = ref.next;
        }
    }
}
