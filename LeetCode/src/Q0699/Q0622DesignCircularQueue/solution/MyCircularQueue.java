package Q0699.Q0622DesignCircularQueue.solution;

public class MyCircularQueue {
    int[] nums;
    int start = 0, len = 0;

    public MyCircularQueue(int k) {
        nums = new int[k];
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        nums[(start + len++) % nums.length] = value;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        start = (start + 1) % nums.length;
        --len;
        return true;
    }

    public int Front() {
        if (isEmpty()) return -1;
        return nums[start];
    }

    public int Rear() {
        if (isEmpty()) return -1;
        return nums[(start + len - 1) % nums.length];
    }

    public boolean isEmpty() {
        return len == 0;
    }

    public boolean isFull() {
        return len == nums.length;
    }
}