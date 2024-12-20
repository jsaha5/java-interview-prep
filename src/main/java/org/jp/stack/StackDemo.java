package org.jp.stack;

public class StackDemo {
    public static void main(String[] args) {
        var stack = new ArrayStack<Integer>(5, Integer.class);
        try {
           stack.push(1);
           stack.push(2);
           stack.push(3);

            stack.print();
            stack.pop();
            stack.print();
        } catch (StackFullException e) {
            System.err.println(e.getMessage());
        } catch (EmptyStackException e) {
            throw new RuntimeException(e);
        }
    }
}
