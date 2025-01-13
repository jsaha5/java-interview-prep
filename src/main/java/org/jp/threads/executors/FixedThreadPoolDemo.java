package org.jp.threads.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        for (int i =1; i<=100 ; i++) {
            service.execute(new Task(i));
        }
        service.shutdown();
    }
}
