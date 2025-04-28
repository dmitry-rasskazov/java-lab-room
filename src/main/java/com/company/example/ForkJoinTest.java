package com.company.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ForkJoinTest
{
    public static void main(String[] args) {
        ExecutorService executorService = ForkJoinPool.commonPool();

        IntStream.range(0, 1000).forEach((i) -> {
            executorService.execute(() -> {
                try {
                    Thread.sleep(5000);
                    System.out.println(i);
                } catch (InterruptedException e) {
                }
            });
        });
    }
}
