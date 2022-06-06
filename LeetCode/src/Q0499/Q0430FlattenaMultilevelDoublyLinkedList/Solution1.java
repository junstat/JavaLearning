package Q0499.Q0430FlattenaMultilevelDoublyLinkedList;

/*
    Basic idea is straight forward:
    1) Start form the head , move one step each time to the next node
    2) When meet with a node with child, say node p, follow its child chain to the end and connect the tail node with
    p.next, by doing this we merged the child chain back to the main thread
    3) Return to p and proceed until find next node with child.
    4) Repeat until reach null
 */

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node(int v) {
        val = v;
    }
};

public class Solution1 {
    public Node flatten(Node head) {
        Node dummy = new Node(0);
        dummy.next = head;
        while (head != null) {
            if (head.child == null) head = head.next;
            else {
                Node nxt = head.next;
                Node chead = flatten(head.child);
                head.next = chead;
                chead.prev = head;
                head.child = null;
                while (head.next != null) head = head.next;
                head.next = nxt;
                if (nxt != null) nxt.prev = head;
                head = nxt;
            }
        }
        return dummy.next;
    }
}