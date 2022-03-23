package com.company.laba7;

public class SuperClass {
    public int number;

    public SuperClass(int number) {
        this.number = number;
    }

    public void set(int number) {
        this.number = number;
    }

    public String toString() {
        return String.format("Class name: %s; number: %d", SuperClass.class.getSimpleName(), this.number);
    }
}
