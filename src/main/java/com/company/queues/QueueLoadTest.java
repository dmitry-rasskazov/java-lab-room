package com.company.queues;

import com.company.messageBus.ConcurrentBlockingLinkedQueueAdapter;

import java.util.Queue;
import java.util.concurrent.*;

public class QueueLoadTest
{
    public static void main(String[] args) {
        BlockingQueue<Runnable> queue = new ConcurrentBlockingLinkedQueueAdapter<>();
        ExecutorService executorService = new ThreadPoolExecutor(4, 4, 0, TimeUnit.SECONDS, queue);

        for(int i = 0; i < 2000; i++) {
            final int finalI = i;
            executorService.execute(() -> {
                System.out.println("C Time: " + (System.currentTimeMillis()) + ", numero: " + finalI);
            });
        }
    }
}
