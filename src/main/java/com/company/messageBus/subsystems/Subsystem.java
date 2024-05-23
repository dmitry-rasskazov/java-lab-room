package com.company.messageBus.subsystems;

import com.bringo.messageBus.annotations.Handler;
import com.company.messageBus.commands.Command3;
import com.company.messageBus.commands.SpecificCommand;
import com.company.messageBus.commands.SpecificCommand1;
import com.company.messageBus.commands.SpecificCommand2;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class Subsystem
{
    private static final Random rand = new Random();

    private final SubsystemUnit subsystemUnit;

    private static final AtomicLong lon = new AtomicLong(0);

    public Subsystem(SubsystemUnit subsystemUnit)
    {
        this.subsystemUnit = subsystemUnit;
    }

    @Handler
    public void method1(SpecificCommand specificCommand)
    {
        for (int i = 0; i < 10; i++) {
            rand.nextLong();
        }

        lon.getAndIncrement();
    }

    @Handler
    public void method2(SpecificCommand1 specificCommand1)
    {
        for (int i = 0; i < 10; i++) {
            rand.nextLong();
        }

        lon.getAndIncrement();
    }

    @Handler
    public void method3(SpecificCommand2 specificCommand2)
    {
        for (int i = 0; i < 10; i++) {
            rand.nextLong();
        }

        lon.getAndIncrement();
    }

    @Handler
    public void method4(Command3 Command3)
    {
        for (int i = 0; i < 10; i++) {
            rand.nextLong();
        }

        long result;

        if((result = lon.incrementAndGet()) % 70000 == 0) {
            System.out.println(System.currentTimeMillis() / 1000 + ": " + result);
        }
    }
}
