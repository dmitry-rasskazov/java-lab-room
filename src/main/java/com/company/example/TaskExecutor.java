package com.company.example;

import io.netty.util.concurrent.DefaultThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskExecutor
{
    public static void main(String[] args)
    {
        System.out.println("Begin of the Main!");

        Example example = new Example();
        example.run();

        System.gc();

        System.out.println("End of the Main!");
    }

    private static class Example
    {
        private final ExecutorService executorService;
        private final Tasks tasks;

        public Example()
        {
            this.tasks = new Tasks(this);
            this.executorService = Executors.newFixedThreadPool(3, new DefaultThreadFactory(
                    "poolName",
                    true,
                    Thread.MAX_PRIORITY
            ));
        }

        public void run()
        {
            this.executorService.execute(this.tasks::test1);
            this.executorService.execute(this.tasks::test2);
            this.executorService.execute(this.tasks::test3);
            this.executorService.execute(this::test);
        }

        private void test()
        {
            System.out.println("Examples->test method");
        }
    }

    public static class Tasks
    {
        private final Example example;

        public Tasks(Example example)
        {
            this.example = example;
        }

        public void test1()
        {
            try {
                while(true) {
                    System.out.println("Test 1");
                    Thread.sleep(5000);
                }
            } catch (Exception exception) {
                System.err.println(exception.getMessage());
                exception.printStackTrace();
            }
        }

        public void test2()
        {
            try {
                while(true) {
                    System.out.println("Test 2");
                    Thread.sleep(7500);
                }
            } catch (Exception exception) {
                System.err.println(exception.getMessage());
                exception.printStackTrace();
            }
        }

        public void test3()
        {
            try {
                while(true) {
                    System.out.println("Test 3");
                    Thread.sleep(5000);
                }
            } catch (Exception exception) {
                System.err.println(exception.getMessage());
                exception.printStackTrace();
            }
        }
    }
}
