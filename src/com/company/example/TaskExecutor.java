package com.company.example;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class TaskExecutor
{
    private static Example example;
    private static Example example2;

    public static void main(String[] args)
    {
        System.out.println("Begin of the Main!");

        example = new Example();
        example2 = new Example();
        example.run();
        example = null;
        System.gc();

        System.out.println("End of the Main!");
    }

    private static class Example
    {
        private final Executor executorService;

        public Example()
        {
            this.executorService = Executors.newSingleThreadExecutor(r -> {
                Thread thread = new Thread(r);
                thread.setName("TaskExecutor-" + r.getClass());

                return thread;
            });
        }

        public void run()
        {
            executorService.execute(() -> {
                System.out.println("Task1 executed");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

            executorService.execute(() -> {
                System.out.println("Task2 executed");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

            executorService.execute(() -> {
                System.out.println("Task3 executed");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

            executorService.execute(() -> {
                System.out.println("Task4 executed");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

            executorService.execute(Example::test);

            executorService.execute(TaskExecutor::test);
        }

        public static void test()
        {
            System.out.println("Test1 successful!");
        }
    }

    public static void test()
    {
        System.out.println("Test2 successful!");
    }
}
