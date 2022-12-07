package Q0699.Q0641DesignCircularDeque.solution2;

public class MyCircularDeque {
    class Node {
        Node prev, next;
        int val;

        Node(int _val) {
            val = _val;
        }
    }

    int cnt, k;
    Node he, ta;

    public MyCircularDeque(int _k) {
        k = _k;
        he = new Node(-1);
        ta = new Node(-1);
        he.next = ta;
        ta.prev = he;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;
        Node node = new Node(value);
        node.next = he.next;
        node.prev = he;
        he.next.prev = node;
        he.next = node;
        cnt++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;
        Node node = new Node(value);
        node.next = ta;
        node.prev = ta.prev;
        ta.prev.next = node;
        ta.prev = node;
        cnt++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        he.next.next.prev = he;
        he.next = he.next.next;
        cnt--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        ta.prev.prev.next = ta;
        ta.prev = ta.prev.prev;
        cnt--;
        return true;
    }

    public int getFront() {
        return isEmpty() ? -1 : he.next.val;
    }

    public int getRear() {
        return isEmpty() ? -1 : ta.prev.val;
    }

    public boolean isEmpty() {
        return cnt == 0;
    }

    public boolean isFull() {
        return cnt == k;
    }
}