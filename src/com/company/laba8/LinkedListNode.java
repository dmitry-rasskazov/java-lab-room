package com.company.laba8;

class LinkedListNode { // КЛАСС – СТРУКТУРА ЭЛЕМЕНТА СПИСКА
    public int value; // значение
    public LinkedListNode next; // поле – ссылка (указатель) на следующий узел
    LinkedListNode(int value, LinkedListNode next) { // конструктор класса
        this.value = value;
        this.next = next;
    }
}