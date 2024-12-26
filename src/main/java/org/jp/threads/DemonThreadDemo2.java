package org.jp.threads;

public class DemonThreadDemo2 {
    public static void main(String[] args) {

        Thread worker  = new Thread(()->{
            System.out.println("Worker thread Running");;

        });
        Thread thread = Thread.currentThread();
        thread.setDaemon(true);
        worker.start();
        System.out.println("Main Thread");

    }
}
