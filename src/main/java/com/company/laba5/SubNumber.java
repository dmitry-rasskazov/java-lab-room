package com.company.laba5;

public class SubNumber {
    private int num;

    public SubNumber() {}

    public void setNum(int num) {
        this.num = Math.min(num, 100);
    }

    public void setNum() {
        this.num = 0;
    }

    public int num() {
        return this.num;
    }
}
