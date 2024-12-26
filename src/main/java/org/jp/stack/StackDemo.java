package org.jp.stack;

public class StackDemo {
    public static void main(String[] args) throws InterruptedException, EmptyStackException {
        var stack = new ArrayStack<Integer>(20, Integer.class);

          Thread t1 = new Thread(()-> {
              try {
                  stack.push(1);
                  stack.push(2);
                  stack.push(3);
                  stack.push(4);
                  stack.pop();
                  stack.push(5);

              } catch (StackFullException e) {
                  throw new RuntimeException(e);
              } catch (EmptyStackException e) {
                  throw new RuntimeException(e);
              }
          });
          Thread t2 = new Thread(()->{
              try {
                  stack.push(100);
                  stack.pop();
                  stack.pop();
                  stack.pop();
                  stack.push(20);
              } catch (EmptyStackException | StackFullException e) {
                  throw new RuntimeException(e);
              }
          });

        t1.setName("Thread 1");
        t2.setName("Thread 2");
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        stack.print();
    }
}
