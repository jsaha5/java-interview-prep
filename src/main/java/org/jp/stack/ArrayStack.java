package org.jp.stack;


import java.lang.reflect.Array;

public class ArrayStack<T> implements StackBase<T> {
    private final int size;
    private int head;
    private final T[] elements;

    @SuppressWarnings("unchecked")
    public ArrayStack(int size, Class<T> type) {
        this.size = size;
        this.head = -1;
        this.elements = (T[]) Array.newInstance(type, size);
    }


    @Override
    public void push(T t) throws StackFullException {
        if (head == size - 1) {
            throw new StackFullException("Stack is full");
        } else {
            elements[++head] = t;
        }
    }

    @Override
    public T pop() throws EmptyStackException {
        isEmpty();
        T data = (T) elements[head];
        head--;
        return data;
    }

    private void isEmpty() throws EmptyStackException {
        if (head == -1) {
            throw new EmptyStackException("Stack is empty");
        }
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
}
