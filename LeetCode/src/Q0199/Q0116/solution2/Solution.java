package Q0199.Q0116.solution2;

import DataStructure.Node;

public class Solution {
    public Node connect(Node root) {
        Node prev = root, cur = null;
        while (prev != null) {
            cur = prev;
            while (cur != null && cur.left != null) {
                // connects the left subtree of same level with right subtree of that same level.
                cur.left.next = cur.right;
                // connects the rightmost node of a level to the leftmost node of the next level.
                if (cur.next != null) cur.right.next = cur.next.left;
                cur = cur.next;
            }
            prev = prev.left;
        }
        return root;
    }
}
