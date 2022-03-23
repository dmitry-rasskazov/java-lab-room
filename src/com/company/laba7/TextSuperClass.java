package com.company.laba7;

public class TextSuperClass {
    private String text;

    public final int len;

    public TextSuperClass(String text) {
        this.len = text.length();
        this.text = text;
    }

    public void setText() {
        this.text = "";
    }

    public void setText(String text) {
        this.text = text;
    }

    public String toString() {
        return String.format("text: %s; len: %d", this.text, this.len);
    }
}
