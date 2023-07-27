package com.company.example;

import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskExecutor
{
    public static void main(String[] args)
    {
        System.out.println("Begin of the Main!");

        Example example = new Example();
        example.run();
        WeakReference<Example> weakReference = new WeakReference<>(example);
        example = null;

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
            this.executorService = Executors.newSingleThreadExecutor(r -> {
                Thread thread = new Thread(r);
                thread.setName("TaskExecutor-" + r.getClass());

                return thread;
            });
        }

        public void run()
        {
            this.executorService.execute(this.tasks::test1);
            this.executorService.execute(this.tasks::test2);
            this.executorService.execute(this.tasks::test3);
            this.executorService.execute(this::test);
            System.out.println(Arrays.toString(this.executorService.shutdownNow().toArray()));
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
                System.out.println("Test 1");
                Thread.sleep(5000);
            } catch (Exception exception) {
                System.err.println(exception.getMessage());
                exception.printStackTrace();
            }
        }

        public void test2()
        {
            try {
                System.out.println("Test 2");
                Thread.sleep(7500);
            } catch (Exception exception) {
                System.err.println(exception.getMessage());
                exception.printStackTrace();
            }
        }

        public void test3()
        {
            try {
                System.out.println("Test 3");
                Thread.sleep(5000);
            } catch (Exception exception) {
                System.err.println(exception.getMessage());
                exception.printStackTrace();
            }
        }
    }
}
