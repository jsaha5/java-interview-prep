package org.jp.threads.procudercousumer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Semaphore;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class ProducerCounsumerWithBinarySemaphore implements Process {
    private List<Integer> list;
    private Semaphore semaphore = new Semaphore(1, true);
    private Lock lock = new ReentrantLock();

    public ProducerCounsumerWithBinarySemaphore() {
        list = new ArrayList<>();

    }

    @Override
    public void consume() throws InterruptedException {
        while (true) {
            semaphore.acquire();
            try {
                System.out.println("Consumer Consuming.....");
                lock.lock();
                while (!list.isEmpty()) {
                    int n = list.removeLast(); // Remove first element
                    System.out.println("Consumer Consumed: " + n);

                }
            } finally {
                lock.unlock();
                semaphore.release();
            }
            Thread.sleep(2000);

        }
    }

    @Override
    public void produce() throws InterruptedException {

        while (true) {
            semaphore.acquire();
            System.out.println("Producer producing");
            try {
                lock.lock();
                IntStream.rangeClosed(1, 5).forEach(num -> {
                            System.out.println("producer Adding :" + num);
                            list.add(num);


                        }
                );
            } finally {
                lock.unlock();
                semaphore.release();
            }
            Thread.sleep(2000);
        }
    }


}
