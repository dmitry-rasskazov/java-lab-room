package com.company.extend;

public class SecondChild extends BaseClass
{

    public SecondChild(String name) {
        super(name);
    }

    @Override
    public Type type()
    {
        return Type.SECOND;
    }
}
