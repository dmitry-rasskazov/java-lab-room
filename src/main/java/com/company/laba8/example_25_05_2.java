package com.company.laba8;

public class example_25_05_2 {
    public static LinkedListNode addAtTail(int value, LinkedListNode tail) {
        return tail.next = new LinkedListNode(value, null);
    }

    public static void main(String[] args) {
        LinkedListNode tail = new LinkedListNode(0, null);
        LinkedListNode head = tail;

        for(int i = 0; i < 9; i++) {
            tail = addAtTail(i+1, tail);
        }

        System.out.println("Проход списка от голвы к хвосту.");
        while(head != null) {
            System.out.printf("Текущее значение элемента списка: %d\n", head.value);
            head = head.next;
        }
    }
}
