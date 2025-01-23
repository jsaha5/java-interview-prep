package org.jp.threads.concurrentcollections;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Producer implements Runnable {

    private int counter;
    private BlockingQueue<Integer> queue;

    public Producer(int counter, BlockingQueue<Integer> queue) {
        this.counter = counter;
        this.queue = queue;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {

            try {
                queue.put(counter);
                Thread.sleep(1000);
                System.out.println("Producer adding " + counter + " to the queue");
                counter++;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class Consumer implements Runnable {

    private BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                int value = queue.take();
                Thread.sleep(2000);
                System.out.println("Consumer consuming " + value + " from the queue");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class BlockingQueueDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        executorService.execute(new Producer(0, queue));
        executorService.execute(new Consumer(queue));
        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(20, TimeUnit.SECONDS)) {
                System.out.println("Executor service timed out......");
                System.out.println("Shutting down the executor service.....");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }

    }
}
