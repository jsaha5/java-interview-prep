package org.jp.threads.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class CallableTask implements Callable<Integer> {
    private final Integer num;

    public CallableTask(Integer num) {
        this.num = num;
    }

    @Override
    public Integer call() throws Exception {
        Thread.sleep(1000);
        return num;
    }
}

public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        List<Future<Integer>> listOfLintFuture = new ArrayList<>();
        for (int i = 0; i < 10; i++) {

            listOfLintFuture.add(service.submit(new CallableTask(i)));
        }
        listOfLintFuture.forEach(futureTask-> {
            try {
                System.out.println(futureTask.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
        service.shutdown();
    }
}
