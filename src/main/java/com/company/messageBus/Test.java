package com.company.messageBus;

import com.bringo.messageBus.CommandDispatcher;
import com.company.messageBus.commands.Command3;
import com.company.messageBus.commands.SpecificCommand1;
import com.company.messageBus.commands.SpecificCommand2;
import com.company.messageBus.subsystems.Subsystem;
import com.company.messageBus.subsystems.SubsystemUnit;
import io.netty.util.concurrent.DefaultThreadFactory;

import java.util.concurrent.*;

public class Test
{
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis() / 1000 + ": 0");
        CommandDispatcher commandBus = new CommandDispatcher(new ScheduledExecutorServiceSafeImpl(new DefaultThreadFactory("Test", true), 10));
        SubsystemUnit unit = new SubsystemUnit();
        commandBus.register(new Subsystem(unit));
        commandBus.register(unit);

        ScheduledExecutorService threadPoolExecutor = Executors.newSingleThreadScheduledExecutor();

        threadPoolExecutor.scheduleAtFixedRate(() -> {
            commandBus.dispatch(new Command3());
            commandBus.dispatch(new Command3());
            commandBus.dispatch(new Command3());
            commandBus.dispatch(new SpecificCommand1());
            commandBus.dispatch(new SpecificCommand1());
            commandBus.dispatch(new SpecificCommand2());
            commandBus.dispatch(new SpecificCommand2());
            commandBus.dispatch(new SpecificCommand1());
            commandBus.dispatch(new SpecificCommand2());
        }, 0, 100, TimeUnit.MICROSECONDS);
    }
}
