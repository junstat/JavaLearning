package Q0199.Q0116PopulatingNextRightPointersinEachNode;

import DataStructure.Node;

public class Solution1 {
    public Node connect(Node root) {
        // base case
        if (root == null) return null;
        // connects the left subtree of same level with right subtree of that same level
        if (root.left != null) root.left.next = root.right;
        // connects the rightmost node of a level to the leftmost node of the next level
        if (root.right != null && root.next != null)
            root.right.next = root.next.left;
        // recursive calls for left and right subtrees.
        connect(root.left);
        connect(root.right);
        return root;
    }
}
