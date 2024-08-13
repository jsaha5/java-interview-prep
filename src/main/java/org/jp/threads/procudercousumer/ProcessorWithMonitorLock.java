package org.jp.threads.procudercousumer;

import java.util.ArrayList;
import java.util.List;

public class ProcessorWithMonitorLock implements Process{

    private List<Integer> list = new ArrayList<>();
    private final int UPPER_LIMIT = 5;
    private final int LOWER_LIMIT = 0;
    private int value = 0;

    @Override
    public void produce() throws InterruptedException {
        synchronized (this) {
            while (true) {
                if (list.size() == UPPER_LIMIT) {
                    System.out.println("Waiting for items to be removed from the list");
                    wait();
                } else {
                    list.add(value);
                    System.out.println("Added " + value + " to the list");
                    value++;
                    notify();
                }
            }
        }

    }

    @Override
    public void consume() throws InterruptedException {
        synchronized (this) {
            while (true) {
                if (list.size() == LOWER_LIMIT) {
                    System.out.println("Waiting for Items to be added to the list");
                    wait();
                } else {
                    var removedValue = list.removeLast();
                    System.out.println("Removed " + removedValue + " from the list");
                    notify();
                }
            }
        }
    }

}
