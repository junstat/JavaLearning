package Q0299.Q0232ImplementQueueusingStacks.solution1;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyQueue {
    Deque<Integer> out, in;

    public MyQueue() {
        in = new ArrayDeque<>();
        out = new ArrayDeque<>();
    }

    public void push(int x) {
        while (!out.isEmpty()) in.addLast(out.pollLast());
        in.addLast(x);
    }

    public int pop() {
        while (!in.isEmpty()) out.addLast(in.pollLast());
        return out.pollLast();
    }

    public int peek() {
        while (!in.isEmpty()) out.addLast(in.pollLast());
        return out.peekLast();
    }

    public boolean empty() {
        return out.isEmpty() && in.isEmpty();
    }
}
