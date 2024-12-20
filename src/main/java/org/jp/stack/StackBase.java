package org.jp.stack;

public interface StackBase<T> {
    void push(T t) throws StackFullException;

    T pop() throws EmptyStackException;

    T peek() throws EmptyStackException;

    void print() throws EmptyStackException;
}
