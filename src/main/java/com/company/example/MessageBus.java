package com.company.example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class MessageBus
{
    public static void main(String[] args) throws InterruptedException
    {
        CommandBus commandBus = new CommandBus();
        SubsystemUnit unit = new SubsystemUnit();
        commandBus.registry(new Subsystem(unit));
        commandBus.registry(unit);

        commandBus.dispatch(new SpecificCommand1(1));
        commandBus.dispatch(new SpecificCommand2(2));
        commandBus.dispatch(new Command3());
    }

    public static abstract class SpecificCommand
    {
        private final int id;

        SpecificCommand(int id) {
            this.id = id;
        }

        public int getId()
        {
            return this.id;
        }
    }

    public static class SpecificCommand1 extends SpecificCommand
    {
        SpecificCommand1(int id) {
            super(id);
        }
    }

    public static class SpecificCommand2 extends SpecificCommand
    {
        SpecificCommand2(int id) {
            super(id);
        }

        public int rand()
        {
            return (new Random()).nextInt();
        }
    }

    public static class Command3
    {
    }

    public static class Subsystem
    {
        private final SubsystemUnit subsystemUnit;

        Subsystem(SubsystemUnit subsystemUnit) {
            this.subsystemUnit = subsystemUnit;
        }

        public void method1(SpecificCommand specificCommand)
        {
            System.out.println("SpecificCommand");
        }

        public void method2(SpecificCommand1 specificCommand1)
        {
            System.out.println("SpecificCommand1");
        }

        public void method3(SpecificCommand2 specificCommand2)
        {
            System.out.println("SpecificCommand2");
        }

        public void method4(Command3 Command3)
        {
            System.out.println("Command3");
        }
    }

    public static class SubsystemUnit
    {
        public void method(SpecificCommand specificCommand)
        {
            System.out.println("Unit SpecificCommand");
        }

        public void method2(Command3 command3)
        {
            System.out.println("Unit Command3");
        }
    }

    private static class CommandBus
    {
        private final Map<Class<?>, List<Method>> methodsMap;
        private final Map<Method, Object> subsystemMap;

        CommandBus() {
            this.methodsMap = new HashMap<>();
            this.subsystemMap = new HashMap<>();
        }

        public <X> void registry(X commandHandler)
        {
            Method[] methods = commandHandler.getClass().getMethods();
            for(Method method: methods) {
                Class<?>[] argumentTypes = method.getParameterTypes();
                if(argumentTypes.length == 1 && !argumentTypes[0].isPrimitive() && method.getReturnType().equals(void.class))
                {
                    List<Method> methodList = this.methodsMap.computeIfAbsent(argumentTypes[0], k -> new LinkedList<>());
                    methodList.add(method);
                    this.subsystemMap.put(method, commandHandler);
                }
            }
        }

        public <X> void dispatch(X command)
        {
            List<Method> commandHandlers = this.getCommandHandlers(command);
            try {
                commandHandlers.forEach((handler) -> {
                    try {
                        handler.invoke(this.subsystemMap.get(handler), command);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                });
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private <X> List<Method> getCommandHandlers(X command)
        {
            List<Method> result = new LinkedList<>();
            Class<?> commandClass = command.getClass();

            while(null != commandClass) {
                result.addAll(this.methodsMap.computeIfAbsent(commandClass, k -> new LinkedList<>()));
                commandClass = commandClass.getSuperclass();
            }

            return result;
        }
    }
}
