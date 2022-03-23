package com.company.laba7;

public class ParentString {
    private String value;

    public ParentString(String value) {
        this.value = value;
    }

    public String toString() {
        return String.format("Class: %s, value: %s", ParentString.class.getSimpleName(), this.value);
    }
}
