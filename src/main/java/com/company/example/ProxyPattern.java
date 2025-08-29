package com.company.example;

import java.util.concurrent.*;

public class ProxyPattern
{
    private static final ExecutorService executor = Executors.newCachedThreadPool();

    public static void main(String[] args) throws InterruptedException {
        String link = "Lsdfsdf123abc*#";
        System.out.println(link.matches("[0-9abc*#]*"));

        System.out.println(System.currentTimeMillis() / 1000);
        CompletableFuture<Short> future = CompletableFuture.supplyAsync(() -> {
            CompletableFuture<Short> result = CompletableFuture.completedFuture((short) 0);

            for(int i = 0; i < 1000; i++) {
                result = result.thenCombineAsync(CompletableFuture.supplyAsync(() -> {
                    short res = (short) Math.abs(ThreadLocalRandom.current().nextInt() % 1000);

                    try {
                        Thread.sleep(res);
                        System.out.println("Thread: " + Thread.currentThread().getName() + ", Result: " + res);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    return res;
                }, executor), (a, b) -> (short) Integer.max(a, b));
            }

            try {
                return result.get();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        });

        future.thenAcceptAsync(result -> {
            System.out.println("Final result: " + result);
            System.out.println(System.currentTimeMillis() / 1000);
            executor.shutdown();
        });
    }
}
