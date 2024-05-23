package com.company.messageBus;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class ScheduledExecutorServiceSafeImpl implements ExecutorService
{
    private static final short TASK_TIMEOUT = 10;

    private static final short TIME_ONE_CLOCK = 100; // ms

    private final short taskTimeout;

    private final ExecutorService executorService;

    private final ExpiredMonitor expiredMonitor;

    private static final ScheduledExecutorService timeoutMonitorExecutor = Executors.newSingleThreadScheduledExecutor();

    public ScheduledExecutorServiceSafeImpl(ThreadFactory threadFactory, int nThreads, int taskTimeoutMillis)
    {
        this.executorService = new ThreadPoolExecutor(nThreads, nThreads, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(), threadFactory);
        this.taskTimeout = (short) (taskTimeoutMillis < 0 ? TASK_TIMEOUT : taskTimeoutMillis);
        this.expiredMonitor = new ExpiredMonitor();
        timeoutMonitorExecutor.scheduleAtFixedRate(this.expiredMonitor, TIME_ONE_CLOCK, TIME_ONE_CLOCK, TimeUnit.MILLISECONDS);
    }

    public ScheduledExecutorServiceSafeImpl(ThreadFactory threadFactory, int nThreads)
    {
        this(threadFactory, nThreads, -1);
    }

    @Override
    public void shutdown()
    {
        this.executorService.shutdown();
    }

    @Override
    public List<Runnable> shutdownNow()
    {
        return this.executorService.shutdownNow();
    }

    @Override
    public boolean isShutdown()
    {
        return this.executorService.isShutdown();
    }

    @Override
    public boolean isTerminated()
    {
        return this.executorService.isTerminated();
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException
    {
        return this.executorService.awaitTermination(timeout, unit);
    }

    @Override
    public <T> Future<T> submit(Callable<T> task)
    {
        return this.executorService.submit(task);
    }

    @Override
    public <T> Future<T> submit(Runnable task, T result)
    {
        return this.executorService.submit(task, result);
    }

    @Override
    public Future<?> submit(Runnable task)
    {
        return this.executorService.submit(task);
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException
    {
        return this.executorService.invokeAll(tasks);
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException
    {
        return this.executorService.invokeAll(tasks, timeout, unit);
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException
    {
        return this.executorService.invokeAny(tasks);
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException
    {
        return this.executorService.invokeAny(tasks, timeout, unit);
    }

    @Override
    public void execute(Runnable command)
    {
        RunnableWrapper wrapper = new RunnableWrapper(command, this.taskTimeout);
        wrapper.addStartListener(() -> this.expiredMonitor.addListener(wrapper));
        wrapper.addCompletedListener(() -> this.expiredMonitor.removeListener(wrapper));
        wrapper.addInterruptedListener(() -> {});

        this.executorService.execute(wrapper);
    }

    private static class RunnableWrapper implements Runnable, Comparable<RunnableWrapper>
    {
        private final AtomicBoolean canceled;

        private final Runnable handler;

        private final int hashCode;

        private final AtomicInteger ttl;

        private Runnable interruptedCallback;

        private Runnable completedCallback;

        private Runnable startListener;

        private Thread currentThread;

        RunnableWrapper(Runnable handler, int initialTtl)
        {
            this.handler = handler;
            this.canceled = new AtomicBoolean(false);
            this.hashCode = Objects.hash(this, canceled, handler);
            this.ttl = new AtomicInteger(initialTtl);
        }

        @Override
        public void run()
        {
            if(null != this.startListener) {
                this.startListener.run();
            }

            this.currentThread = Thread.currentThread();

            this.handler.run();

            if(null != this.completedCallback) {
                this.completedCallback.run();
            }

            this.cancel();
        }

        public void addStartListener(Runnable startListener)
        {
            this.startListener = startListener;
        }

        public void addInterruptedListener(Runnable interruptedCallback)
        {
            this.interruptedCallback = interruptedCallback;
        }

        public void addCompletedListener(Runnable completedCallback)
        {
            this.completedCallback = completedCallback;
        }

        public void interrupt()
        {
            if(!this.canceled.get()) {
                this.canceled.set(true);
                this.currentThread.interrupt();

                this.interruptedCallback();
                this.completedCallback();
            }
        }

        public int decrementAndGetTtl()
        {
            int currentTtl = this.ttl.decrementAndGet();

            if(currentTtl == 0) {
                this.interrupt();
            }

            return currentTtl;
        }

        @Override
        public int hashCode()
        {
            return this.hashCode;
        }

        @Override
        public int compareTo(RunnableWrapper runnableWrapper)
        {
            return Integer.compare(this.hashCode(), runnableWrapper.hashCode());
        }

        private void cancel()
        {
            if(!this.canceled.get()) {
                this.canceled.set(true);
            }
        }

        private void interruptedCallback()
        {
            if(null != this.interruptedCallback) {
                this.interruptedCallback.run();
            }
        }

        private void completedCallback()
        {
            if(null != this.completedCallback) {
                this.completedCallback.run();
            }
        }
    }

    private static class ExpiredMonitor implements Runnable
    {
        private final Queue<RunnableWrapper> listeners;

        ExpiredMonitor() {
            this.listeners = new ConcurrentLinkedQueue<>();
        }

        @Override
        public void run()
        {
            RunnableWrapper wrapper;
            while ((wrapper = this.listeners.poll()) != null) {
                if(wrapper.decrementAndGetTtl() > 0) {
                    this.listeners.add(wrapper);
                }
            }
        }

        public void addListener(RunnableWrapper runnableWrapper)
        {
            this.listeners.add(runnableWrapper);
        }

        public void removeListener(RunnableWrapper runnableWrapper)
        {
            this.listeners.remove(runnableWrapper);
        }

        public int size()
        {
            return this.listeners.size();
        }
    }
}
