package com.company.extend;

public class Factory
{
    public BaseClass create(String name, byte serviceIndicator)
    {
        switch (serviceIndicator)
        {
            case 0: return new FirstChild(name);

            case 1: return new SecondChild(name);

            default: throw new IllegalArgumentException("ServiceIndicator must be 0 or 1");
        }
    }
}
