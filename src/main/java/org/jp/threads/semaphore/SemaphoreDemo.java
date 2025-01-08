package org.jp.threads.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class SemaphoreDemo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        IntStream.rangeClosed(0, 13).forEach(i -> executor.execute(Downloader.
                INSTANCE::download));
        System.out.println("exit");
    }
}
