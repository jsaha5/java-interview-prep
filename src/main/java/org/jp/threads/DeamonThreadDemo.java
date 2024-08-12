package org.jp.threads;

public class DeamonThreadDemo {
    public static void main(String[] args) {
        // jvm stops deamon thread once all worker threads finish executing

        Thread deamonThread = new Thread(() -> {
            while (true){
                System.out.println("Demon Thread Running");
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        });

        Thread worker = new Thread(() -> {
            System.out.println("Worker thread working");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Worker thread finished working");

        });

        deamonThread.setDaemon(true);

        deamonThread.start();
        worker.start();
    }

}
