package com.company.messageBus;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentBlockingLinkedQueueAdapter<T> implements BlockingQueue<T>
{
    private final Queue<T> queue = new ConcurrentLinkedQueue<>();

    private final AtomicInteger size = new AtomicInteger(0);

    private final Lock lock = new ReentrantLock();

    @Override
    public boolean add(T T) {
        this.getAndIncrementSize();
        return this.queue.add(T);
    }

    @Override
    public boolean offer(T T) {
        this.getAndIncrementSize();
        return this.queue.offer(T);
    }

    @Override
    public void put(T T) throws InterruptedException
    {
        this.getAndIncrementSize();
        this.queue.add(T);
    }

    @Override
    public boolean offer(T T, long timeout, TimeUnit unit) throws InterruptedException {
        this.getAndIncrementSize();
        return this.queue.offer(T);
    }

    @Override
    public T take() throws InterruptedException {
        this.getAndDecrementSize();

        return this.queue.poll();
    }

    @Override
    public T poll(long timeout, TimeUnit unit) throws InterruptedException {
        this.getAndDecrementSize();
        return this.queue.poll();
    }

    @Override
    public int remainingCapacity() {
        return this.size.get();
    }

    @Override
    public boolean remove(Object object) {
        this.getAndDecrementSize();
        return this.queue.remove(object);
    }

    @Override
    public boolean contains(Object object) {
        return this.queue.contains(object);
    }

    @Override
    public int drainTo(Collection<? super T> collection) {
        int removedElement = 0;
        for (Object item: collection) {
            if(this.queue.remove(item)) {
                removedElement++;
                this.getAndDecrementSize();
            }
        }

        return removedElement;
    }

    @Override
    public int drainTo(Collection<? super T> collection, int maxElements) {
        int removedElement = 0;
        for (Object item: collection) {
            if(maxElements <= removedElement) {
                break;
            }

            if(this.queue.remove(item)) {
                removedElement++;
                this.getAndDecrementSize();
            }
        }

        return removedElement;
    }

    @Override
    public T remove() {
        this.getAndDecrementSize();
        return this.queue.remove();
    }

    @Override
    public T poll() {
        this.getAndDecrementSize();
        return this.queue.poll();
    }

    @Override
    public T element() {
        return this.queue.element();
    }

    @Override
    public T peek() {
        return this.queue.peek();
    }

    @Override
    public int size() {
        return this.size.get();
    }

    @Override
    public boolean isEmpty() {
        return this.size.get() == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return this.queue.iterator();
    }

    @Override
    public Object[] toArray() {
        return this.queue.toArray();
    }

    @Override
    public <X> X[] toArray(X[] array) {
        return this.queue.toArray(array);
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return this.queue.containsAll(collection);
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        boolean added = false;

        for(T item: collection) {
            this.add(item);
            added = true;
        }

        return added;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean removed = false;

        for(Object item: collection) {
            removed = this.remove(item);
        }

        return removed;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return this.queue.retainAll(collection);
    }

    @Override
    public void clear() {
        this.queue.clear();
        this.size.set(0);
    }

    private void getAndDecrementSize()
    {
        this.size.getAndDecrement();
    }

    private void getAndIncrementSize()
    {
        this.size.getAndDecrement();
    }
}
