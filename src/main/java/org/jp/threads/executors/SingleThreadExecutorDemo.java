package org.jp.threads.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutorDemo {

    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        for (int i =1; i<=5 ; i++) {
            service.execute(new Task(i));
        }
    }
}
