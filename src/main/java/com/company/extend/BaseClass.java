package com.company.extend;

public abstract class BaseClass
{
    private final String name;

    public BaseClass(String name)
    {
        if(null == name) {
            throw new IllegalArgumentException("Name cannot be NULL");
        }

        this.name = name;
    }

    public abstract Type type();

    public String name()
    {
        return this.name;
    }
}
