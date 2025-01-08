package org.jp.threads.deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLock {
    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();
    private void worker1  ()  {
        lock1.lock();
        System.out.println("Worker1 acquires Lock 1");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock2.lock();
        System.out.println("Worker1 acquires Lock 2");
        lock1.unlock();
        lock2.unlock();

    };
    private void worker2() {
        lock1.lock();
        System.out.println("Worker2 acquires Lock 2");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock2.lock();
        System.out.println("Worker1 acquires Lock 1");
        lock1.unlock();
        lock2.unlock();
    };

    public static void main(String[] args) {
        DeadLock deadLock =new DeadLock();
        new Thread(deadLock::worker1, "Worker1").start();
        new Thread(deadLock::worker2, "Worker2").start();

    }



}
