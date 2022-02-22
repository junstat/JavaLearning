package Q0299.Q0225ImplementStackusingQueues;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {

}

class MyStack {
    private Queue<Integer> queue = new ArrayDeque<>();

    public MyStack() {

    }

    public void push(int x) {
        queue.add(x);
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.poll());
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}