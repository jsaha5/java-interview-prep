package org.jp.threads;

import java.util.stream.IntStream;

public class ThreadSynchronization {
    public static int counter = 0;

    private static void increment() {
       // class level locking
        synchronized (ThreadSynchronization.class) {
            counter++;
        }
    }

    static Runnable worker = () -> IntStream.rangeClosed(1, 100).forEach(i -> increment());

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(worker);
        Thread t2 = new Thread(worker);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(counter);
    }
}
