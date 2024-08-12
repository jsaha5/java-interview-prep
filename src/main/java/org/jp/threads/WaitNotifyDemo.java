package org.jp.threads;

class Process {

    public void produce() throws InterruptedException {
        synchronized (this) {
            System.out.println("inside produce ");
            wait();
            System.out.println("Again inside produce");
        }
    }

    public void consume() throws InterruptedException {
        synchronized (this) {
            System.out.println("inside consume");
           notify();
            Thread.sleep(5000);
        }
    }
}


public class WaitNotifyDemo {
    public static void main(String[] args) throws InterruptedException {
        Process p = new Process();
        Thread t1 = new Thread(() -> {
            try {
                p.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                p.produce();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t2.start();
        t1.start();
    }
}
