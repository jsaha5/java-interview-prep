package org.jp.threads.semaphore;

import java.util.concurrent.Semaphore;

public class BinarySemaphoreExample {
    private static Semaphore semaphore = new Semaphore(1); // Binary semaphore

    public static void main(String[] args) {
        Thread producer = new Thread(() -> {
            try {
                System.out.println("Producing item...");
                Thread.sleep(1000); // Simulate production
                semaphore.release(); // Signal
                System.out.println("Item produced and semaphore signaled.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                System.out.println("Consumer waiting for item...");
                semaphore.acquire(); // Wait for signal
                System.out.println("Item consumed.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producer.start();
        consumer.start();
    }
}