package com.company.extend;

public class FirstChild extends BaseClass
{
    public FirstChild(String name) {
        super(name);
    }

    @Override
    public Type type()
    {
        return Type.FIRST;
    }
}
