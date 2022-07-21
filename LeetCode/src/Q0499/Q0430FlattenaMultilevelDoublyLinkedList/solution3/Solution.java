package Q0499.Q0430FlattenaMultilevelDoublyLinkedList.solution3;

import Q0499.Q0430FlattenaMultilevelDoublyLinkedList.Node;

public class Solution {
    public Node flatten(Node head) {
        Node dummy = new Node(0);
        dummy.next = head;
        while (head != null) {
            if (head.child != null) {
                Node tmp = head.next;
                Node child = head.child;
                head.next = child;
                child.prev = head;
                head.child = null;
                Node last = head;
                while (last.next != null) last = last.next;
                last.next = tmp;
                if (tmp != null) tmp.prev = last;
            }
            head = head.next;
        }
        return dummy.next;
    }
}