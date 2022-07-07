package Q0299.Q0232ImplementQueueusingStacks.solution2;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyQueue {
    Deque<Integer> out, in;

    public MyQueue() {
        in = new ArrayDeque<>();
        out = new ArrayDeque<>();
    }

    public void push(int x) {
        in.addLast(x);
    }

    public int pop() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) out.addLast(in.pollLast());
        }
        return out.pollLast();
    }

    public int peek() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) out.addLast(in.pollLast());
        }
        return out.peekLast();
    }

    public boolean empty() {
        return out.isEmpty() && in.isEmpty();
    }
}
