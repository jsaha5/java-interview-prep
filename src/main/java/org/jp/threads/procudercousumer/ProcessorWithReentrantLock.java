package org.jp.threads.procudercousumer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProcessorWithReentrantLock implements Process {

    private List<Integer> list;
    private final int UPPER_LIMIT = 5;
    private final int LOWER_LIMIT = 0;
    private int value = 0;
    private Lock lock;

    private Condition condition;

    public ProcessorWithReentrantLock() {
        this.list = new ArrayList<>();
        this.lock = new ReentrantLock();
        this.condition = lock.newCondition();
    }

    @Override
    public void consume() throws InterruptedException {
        while (true) {
            lock.lock();
            if (list.size() == LOWER_LIMIT) {
                System.out.println("Waiting for Producer to produce");
                condition.await();
                lock.unlock();

            } else {
                System.out.println("Removed: " + list.removeLast());
                condition.signal();
            }

        }
    }

    @Override
    public void produce() throws InterruptedException {

        while (true) {
            lock.lock();
            if (list.size() == UPPER_LIMIT) {
                System.out.println("Waiting for Consumer to consume");
                condition.await();
                Thread.sleep(3000);
                lock.unlock();

            } else {
                System.out.println("Added : "+ value);
                list.add(value);
                value++;
                condition.signal();
            }

        }
    }


}
