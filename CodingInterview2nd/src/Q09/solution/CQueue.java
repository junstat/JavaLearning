package Q09.solution;

import java.util.ArrayDeque;
import java.util.Deque;

public class CQueue {
    Deque<Integer> in = new ArrayDeque<>();
    Deque<Integer> out = new ArrayDeque<>();

    public CQueue() {

    }

    public void appendTail(int value) {
        in.addLast(value);
    }

    public int deleteHead() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) out.addLast(in.pollLast());
        }
        return out.isEmpty() ? -1 : out.pollLast();
    }
}