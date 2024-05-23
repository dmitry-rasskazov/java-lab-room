package com.company.messageBus.subsystems;

import com.bringo.messageBus.annotations.Handler;
import com.company.messageBus.commands.Command3;
import com.company.messageBus.commands.SpecificCommand;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class SubsystemUnit
{
    private static final Random rand = new Random();

    private static final AtomicLong lon = new AtomicLong(0);

    @Handler
    public void method(SpecificCommand specificCommand)
    {
        for (int i = 0; i < 10; i++) {
            rand.nextLong();
        }

        lon.getAndIncrement();
    }

    @Handler
    public void method2(Command3 command3)
    {
        for (int i = 0; i < 10; i++) {
            rand.nextLong();
        }

        lon.getAndIncrement();
    }
}