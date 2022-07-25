package Q0699.Q0641DesignCircularDeque.solution;

public class MyCircularDeque {
    int[] q;
    int begin = 0, end = 0, k, cnt = 0;

    public MyCircularDeque(int _k) {
        k = _k;
        q = new int[k];
    }

    public boolean insertFront(int value) {
        if (cnt == k) return false;
        begin = (begin - 1 + k) % k;
        q[begin] = value;
        ++cnt;
        return true;
    }

    public boolean insertLast(int value) {
        if (cnt == k) return false;
        q[end] = value;
        end = (end + 1) % k;
        ++cnt;
        return true;
    }

    public boolean deleteFront() {
        if (cnt == 0) return false;
        begin = (begin + 1) % k;
        --cnt;
        return true;
    }

    public boolean deleteLast() {
        if (cnt == 0) return false;
        end = (end - 1 + k) % k;
        --cnt;
        return true;
    }

    public int getFront() {
        if (cnt == 0) return -1;
        return q[begin];
    }

    public int getRear() {
        if (cnt == 0) return -1;
        return q[(end - 1 + k) % k];
    }

    public boolean isEmpty() {
        return cnt == 0;
    }

    public boolean isFull() {
        return cnt == k;
    }
}