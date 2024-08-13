package org.jp.threads.procudercousumer;

public interface Process {
    void produce() throws InterruptedException;
    void consume() throws InterruptedException;
}
