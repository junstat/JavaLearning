package Q0199.Q0117.solution1;

import DataStructure.Node;

public class Solution {
    public Node connect(Node root) {
        Node head = root;
        while (head != null) {
            Node dummy = new Node(0);       // 每一层设置一个链表头结点，用于统一插入操作
            Node cur = dummy;
            while (head != null) {
                if (head.left != null) {
                    cur.next = head.left;
                    cur = cur.next;
                }
                if (head.right != null) {
                    cur.next = head.right;
                    cur = cur.next;
                }
                head = head.next;
            }
            head = dummy.next;      // 下一层
        }
        return root;
    }
}
