package com.company.laba7;

public class ChildString extends ParentString {
    private String value;

    public ChildString(String value) {
        super(value);
    }

    public ChildString(String pValue, String cValue) {
        super(pValue);
        this.value = cValue;
    }

    @Override
    public String toString() {
        return (null != this.value)
                ? String.format("%s; Class: %s, value: %s", super.toString(), ChildString.class.getSimpleName(), this.value)
                : String.format("%s", super.toString())
        ;
    }
}
