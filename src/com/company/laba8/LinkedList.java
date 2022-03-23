package com.company.laba8;

import com.sun.istack.internal.NotNull;

import java.util.Arrays;

public class LinkedList {
    private @NotNull LinkedListNode head;

    private LinkedList(LinkedListNode head) {
        this.head = head;
    }

    public static LinkedList createHead(int[] values) {
        LinkedListNode head = null;
        for (int value: values) {
            head = new LinkedListNode(value, head);
        }

        return new LinkedList(head);
    }

    public static LinkedList createTail(int[] values) {
        LinkedListNode head = new LinkedListNode(values[0], null);
        LinkedListNode ref = head;
        for (int i = 1; i < values.length; i++) {
            ref.next = new LinkedListNode(values[i], null);
            ref = ref.next;
        }

        return new LinkedList(head);
    }

    public void insert(int position, int value) {
        if(position <= 0) {
            addFirst(value);
            return;
        }
        LinkedListNode ref = this.head;
        for(int i = 0; i < position-1; ref = ref.next, i++);

        ref.next = new LinkedListNode(value, ref.next);
    }

    public void addFirst(int value) {
        this.head = new LinkedListNode(value, this.head);
    }

    public void addLast(int value) {
        LinkedListNode ref = this.head;
        while(ref.next != null) {
            ref = ref.next;
        }
        ref.next = new LinkedListNode(value, null);
    }

    public void removeFirst() {
        this.head = this.head.next;
    }

    public void removeLast() {
        LinkedListNode ref = this.head;
        while(ref.next != null && ref.next.next != null) {
            ref = ref.next;
        }
        ref.next = null;
    }

    public void remove(int position) {
        if(position <= 0) {
            removeFirst();
            return;
        }
        LinkedListNode ref = this.head;
        for(int i = 0; i < position-1; ref = ref.next, i++);

        ref.next = ref.next.next;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        LinkedListNode ref = this.head;
        while (ref != null) {
            result.append(ref.value);
            result.append(' ');
            ref = ref.next;
        }
        return result.toString();
    }

    public static LinkedList createHeadRec(int[] values) {
        LinkedListNode head = new LinkedListNode(values[0], null);

        if(values.length > 1) {
            head = createHeadRec(Arrays.stream(values).skip(1).toArray(), head);
        }

        return new LinkedList(head);
    }

    private static LinkedListNode createHeadRec(int[] values, LinkedListNode node) {
        LinkedListNode head = new LinkedListNode(values[0], node);

        if(values.length > 1) {
            return createHeadRec(Arrays.stream(values).skip(1).toArray(), head);
        }

        return head;
    }

    public static LinkedList createTailRec(int[] values) {
        LinkedListNode head = new LinkedListNode(values[0], null);

        if(values.length > 1) {
            createTailRec(Arrays.stream(values).skip(1).toArray(), head);
        }

        return new LinkedList(head);
    }

    private static void createTailRec(int[] values, LinkedListNode head) {
        head.next = new LinkedListNode(values[0], null);

        if(values.length > 1) {
            createTailRec(Arrays.stream(values).skip(1).toArray(), head.next);
        }
    }

    public String toStringRec() {
        LinkedListNode node = this.head;
        if(node.next != null) {
            return String.valueOf(node.value) + " " + toStringRec(node.next);
        }

        return String.valueOf(node.value);
    }

    public String toStringRec(LinkedListNode node) {
        if(node.next != null) {
            return node.value + " " + toStringRec(node.next);
        }

        return String.valueOf(node.value);
    }
}
