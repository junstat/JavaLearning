package Q30.solution;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {
    Deque<Integer> data = new ArrayDeque<>();
    Deque<Integer> helper = new ArrayDeque<>();

    public void push(int val) {
        data.addLast(val);
        if (helper.isEmpty() || helper.peekLast() >= val) helper.addLast(val);
        else helper.addLast(helper.peekLast());
    }

    public void pop() {
        data.pollLast();
        helper.pollLast();
    }

    public int top() {
        return data.peekLast();
    }

    public int min() {
        return helper.peekLast();
    }
}