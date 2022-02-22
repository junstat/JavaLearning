package Q0299.Q0232ImplementQueueusingStacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

}

class MyQueue {
    private Deque<Integer> input = new ArrayDeque<>();
    private Deque<Integer> output = new ArrayDeque<>();

    public MyQueue() {

    }

    public void push(int x) {
        input.add(x);
    }

    public int pop() {
        peek();
        return output.poll();
    }

    public int peek() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.add(input.poll());
            }
        }
        return output.peek();
    }

    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}