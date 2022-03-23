package com.company.laba5;

public class Range {
    private int min = 0;
    private int max = 0;

    public Range(int min, int max) {
        this.setFields(min, max);
    }

    public void setFields(int min, int max) {
        if(this.isValidRange(min, max)) {
            this.setFields(min, max);
        } else {
            this.printError();
        }
    }

    public void setFields(int value) {
        int nextMin = Math.min(this.min, value), nextMax = Math.max(this.max, value);
        if(this.isValidRange(nextMin, nextMax)) {
            this.min = nextMin;
            this.max = nextMax;
        } else {
            this.printError();
        }
    }

    public void printFields() {
        System.out.printf("\nМинимальное значение - %d, а максимальное - %d", this.min, this.max);
    }

    private boolean isValidRange(int min, int max) {
        return min <= max;
    }

    private void printError() {
        System.out.println("Введены невалидные значения!");
    }
}
