package org.jp.threads;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ThreadCreation {
    public static void main(String[] args) {

        Runnable runner = () ->
                IntStream.range(1, 10).forEach(i -> {
                            System.out.println(Thread.currentThread().getName() + i);
                           /* try {
                                //Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }*/
                        }
                );
        Thread t1 = new Thread(runner
        );
        t1.setName("Runner 1 ");
        Thread t2 = new Thread(runner
        );
        t2.setName("Runner 2 ");
        t1.setPriority(10);
        t1.start();

        t2.start();

//        try {
//            t1.join();
//            t2.join();
//
//        } catch (InterruptedException e) {
//          e.printStackTrace();
//        }
        System.out.println("All threads finished working");
    }
}
