package Q0499.Q0430FlattenaMultilevelDoublyLinkedList.solution2;


import Q0499.Q0430FlattenaMultilevelDoublyLinkedList.Node;

public class Solution {
    public Node flatten(Node head) {
        dfs(head);
        return head;
    }

    Node dfs(Node head) {
        Node last = head;
        while (head != null) {
            if (head.child == null) {
                last = head;
                head = head.next;
            } else {
                Node nxt = head.next;
                Node childLast = dfs(head.child);
                head.next = head.child;
                head.child.prev = head;
                head.child = null;
                if (childLast != null) childLast.next = nxt;
                if (nxt != null) nxt.prev = childLast;
                last = head;
                head = childLast;
            }
        }
        return last;
    }
}
