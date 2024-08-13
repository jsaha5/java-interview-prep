package org.jp.threads.procudercousumer;


public class ProducerConsumerDemo {
    public static void main(String[] args) {
        Process processor = new ProcessorWithReentrantLock();

        Thread producer = new Thread(() -> {
            try {
                processor.produce();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                processor.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        producer.start();
        consumer.start();
    }
}
