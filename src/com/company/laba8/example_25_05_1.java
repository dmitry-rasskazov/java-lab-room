package com.company.laba8;

public class example_25_05_1 {
    public static LinkedListNode addAtHead(int value, LinkedListNode head) {
        return new LinkedListNode(value, head);
    }

    public static void main(String[] args) {
        LinkedListNode head = null;

        for(int i = 0; i < 10; i++) {
            head = addAtHead(i, head);
        }

        System.out.println("Проход списка от голвы к хвосту.");
        while(head != null) {
            System.out.printf("Текущее значение элемента списка: %d\n", head.value);
            head = head.next;
        }
    }
}
