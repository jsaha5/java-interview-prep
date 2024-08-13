package org.jp.threads.procudercousumer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProcessorWithReentrantLock implements Process {

    private List<Integer> list ;
    private final int UPPER_LIMIT = 5;
    private final int LOWER_LIMIT = 0;
    private int value  = 0;
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
            if (list.size() == LOWER_LIMIT) {
                System.out.println("Waiting for items to get added ....");
                condition.signal();
                lock.unlock();
            } else {
                lock.lock();
                condition.await();
                System.out.println("Removing " + list.removeLast());
            }
        }
    }

    @Override
    public void produce()  throws InterruptedException{

        while (true) {
            if (list.size() == UPPER_LIMIT) {
                System.out.println("Waiting for items to be removed ....");
                condition.signal();
                lock.unlock();
            } else {
                lock.lock();
                list.add(value);
                System.out.println("Added: " + value);
                value++;

            }
        }
    }


}
