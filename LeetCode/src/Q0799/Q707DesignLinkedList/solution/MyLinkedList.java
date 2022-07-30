package Q0799.Q707DesignLinkedList.solution;

public class MyLinkedList {
    static class MyListNode {
        int val;
        MyListNode next = null;

        MyListNode(int v) {
            val = v;
        }
    }

    MyListNode dummy = new MyListNode(0), tail = dummy;
    int len = 0;

    public MyLinkedList() {

    }

    public int get(int index) {
        if (index >= len) return -1;
        MyListNode p = dummy.next;
        while (index-- > 0) p = p.next;
        return p.val;
    }

    public void addAtHead(int val) {
        MyListNode node = new MyListNode(val);
        node.next = dummy.next;
        dummy.next = node;
        if (tail == dummy) tail = node;
        ++len;
    }

    public void addAtTail(int val) {
        tail.next = new MyListNode(val);
        tail = tail.next;
        ++len;
    }

    public void addAtIndex(int index, int val) {
        if (index > len) return;
        MyListNode node = new MyListNode(val);
        if (index == len) {
            tail.next = node;
            tail = node;
        } else {
            MyListNode p = dummy;
            while (index-- > 0) p = p.next;
            node.next = p.next;
            p.next = node;
        }
        ++len;
    }

    public void deleteAtIndex(int index) {
        if (index >= len) return;
        MyListNode p = dummy;
        while (index-- > 0) p = p.next;
        MyListNode node = p.next;
        p.next = node.next;
        if (tail == node) tail = p;
        --len;
    }
}