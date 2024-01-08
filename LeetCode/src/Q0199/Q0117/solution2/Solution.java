package Q0199.Q0117.solution2;

import DataStructure.Node;

public class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        if (root.left != null) {
            root.left.next = root.right != null ? root.right : findNext(root.next);
        }
        if (root.right != null)
            root.right.next = findNext(root.next);
        connect(root.right); // update the right nodes first
        connect(root.left);
        return root;
    }

    Node findNext(Node root) {
        if (root == null) return null;
        if (root.left != null) return root.left;
        if (root.right != null) return root.right;
        return findNext(root.next);
    }
}
