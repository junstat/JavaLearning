package Q0199.Q0116PopulatingNextRightPointersinEachNode;

import DataStructure.Node;

/*
    Algorithm:
    1. Base case: if the root is null than return null
    2. Now to connect the left subtree of same level with right subtree of that level
    3. The only new line that differentiate from level order traversing is that we need to connect the rightmost node
    of a level to the leftmost node of the next level.
    4. Now just repeat the steps over and over for every level of tree .
 */
public class Solution {
    /*
        Approach 1: Recursion
     */
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
