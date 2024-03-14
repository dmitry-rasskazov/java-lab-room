package com.company.example;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
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
            System.out.println(this.hashCode());
        }

        public void method1(SpecificCommand specificCommand)
        {
            System.out.println("SpecificCommand: ");
        }

        public void method2(SpecificCommand1 specificCommand1)
        {
            System.out.println("SpecificCommand1: ");
        }

        public void method3(SpecificCommand2 specificCommand2)
        {
            System.out.println("SpecificCommand2: ");
        }

        public void method4(Command3 Command3)
        {
            System.out.println("Command3: ");
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
        private final Map<Class<?>, List<MethodInvoker>> methodsMap;

        CommandBus() {
            this.methodsMap = new HashMap<>();
        }

        public <X> void registry(X commandHandler)
        {
            MethodHandles.Lookup publicLookup = MethodHandles.publicLookup();

            Class<?> commandHandlerClass = commandHandler.getClass();
            Method[] methods = commandHandlerClass.getMethods();
            for(Method method: methods) {
                Class<?>[] argumentTypes = method.getParameterTypes();
                if(argumentTypes.length == 1 && !argumentTypes[0].isPrimitive() && method.getReturnType().equals(void.class))
                {
                    try {
                        Class<?> parameterType = argumentTypes[0];
                        MethodType methodType = MethodType.methodType(void.class, parameterType);
                        MethodHandle methodHandle = publicLookup.findVirtual(commandHandlerClass, method.getName(), methodType);

                        List<MethodInvoker> methodList = this.methodsMap.computeIfAbsent(parameterType, k -> new LinkedList<>());
                        methodList.add(new MethodInvoker(commandHandler, methodHandle));
                    } catch (NoSuchMethodException | IllegalAccessException exception) {
                        throw new RuntimeException(exception);
                    }
                }
            }
        }

        public <X> void dispatch(X command)
        {
            List<MethodInvoker> commandHandlers = this.getCommandHandlers(command);
            commandHandlers.forEach((invoker) -> invoker.handle(command));
        }

        private <X> List<MethodInvoker> getCommandHandlers(X command)
        {
            List<MethodInvoker> result = new LinkedList<>();
            Class<?> commandClass = command.getClass();

            while(null != commandClass) {
                result.addAll(this.methodsMap.computeIfAbsent(commandClass, k -> new LinkedList<>()));
                commandClass = commandClass.getSuperclass();
            }

            return result;
        }
    }

    private static class MethodInvoker
    {
        private final Object context;

        private final MethodHandle methodHandle;

        MethodInvoker(Object context, MethodHandle methodHandle) {
            this.context = context;
            this.methodHandle = methodHandle;
        }

        public <X> void handle(X command)
        {
            try {
                this.methodHandle.invokeWithArguments(this.context, command);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public int hashCode()
        {
            return Objects.hash(super.hashCode(), this.context, this.methodHandle);
        }
    }
}
