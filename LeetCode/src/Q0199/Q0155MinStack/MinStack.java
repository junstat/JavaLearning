package Q0199.Q0155MinStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {
    Deque<Integer> data = new ArrayDeque<>();
    Deque<Integer> help = new ArrayDeque<>();

    public void push(int val) {
        data.addLast(val);
        if (help.isEmpty() || help.peekLast() >= val) {
            help.addLast(val);
        } else {
            help.addLast(help.peekLast());
        }
    }

    public void pop() {
        data.pollLast();
        help.pollLast();
    }

    public int top() {
        return data.peekLast();
    }

    public int getMin() {
        return help.peekLast();
    }
}