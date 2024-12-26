package org.jp.stack;


import java.lang.reflect.Array;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ArrayStack<T> implements StackBase<T> {
    private final int size;
    private int head;
    private final T[] elements;
    private Lock lock;
    private Condition condition;

    @SuppressWarnings("unchecked")
    public ArrayStack(int size, Class<T> type) {
        this.size = size;
        this.head = -1;
        this.elements = (T[]) Array.newInstance(type, size);
        this.lock = new ReentrantLock();
        this.condition = lock.newCondition();
    }


    @Override
    public void push(T t) throws StackFullException {
        if (head == size - 1) {
            throw new StackFullException("Stack is full");
        } else {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " got the lock ");
            elements[++head] = t;
            System.out.println(Thread.currentThread().getName() + " added " + t + " To the stack");
            lock.unlock();
        }
    }

    @Override
    public T pop() throws EmptyStackException {
        isEmpty();
        lock.lock();
        System.out.println(Thread.currentThread().getName() + " got the lock ");
        T data = (T) elements[head];
        System.out.println(Thread.currentThread().getName() + " removed  "+ data + " From the stack");
        head--;
        lock.unlock();
        return data;
    }

    @Override
    public T peek() throws EmptyStackException {
        isEmpty();
        return (T) elements[head];
    }

    @Override
    public void print() throws EmptyStackException {
        isEmpty();
        for (int i = head; i >= 0; i--) {
            System.out.println(elements[i]);
        }

    }

    private void isEmpty() throws EmptyStackException {
        if (head == -1) {
            throw new EmptyStackException("Stack is empty");
        }
    }

}
