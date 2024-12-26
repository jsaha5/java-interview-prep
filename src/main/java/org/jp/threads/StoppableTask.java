package org.jp.threads;

class Task implements Runnable {
    private volatile boolean terminated = false;

    @Override
    public void run() {
        while (!terminated) {
            System.out.println("Task running...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void stop(boolean terminated) {
        this.terminated = terminated;
    }
}

public class StoppableTask {
    public static void main(String[] args) throws InterruptedException {
        Task stopableTask = new Task();
        Thread t = new Thread(stopableTask);
        Thread t2 = new Thread(() -> {
            try {
                System.out.println("T2 runnning.....");
                Thread.sleep(5000);
                stopableTask.stop(true);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t.start();
        t2.start();
        t.join();
        t2.join();
        System.out.println("Main thread exit...");
    }
}
