package Q0399.Q0337HouseRobberIII.solution1;

import DataStructure.TreeNode;

/*
    Step I -- Think naively
    At first glance, the problem exhibits the feature of "optimal substructure": if we want to rob maximum amount of
    money from current binary tree (rooted at root), we surely hope that we can do the same to its left and right
    subtrees.

    So going along this line, let's define the function rob(root) which will return the maximum amount of money that
    we can rob for the binary tree rooted at root; the key now is to construct the solution to the original problem
    from solutions to its subproblems, i.e., how to get rob(root) from rob(root.left), rob(root.right), ... etc.

    Apparently the analyses above suggest a recursive solution. And for recursion, it's always worthwhile figuring
    out the following two properties:
        Termination condition: when do we know the answer to rob(root) without any calculation? Of course when the
        tree is empty ---- we've got nothing to rob so the amount of money is zero.

        Recurrence relation: i.e., how to get rob(root) from rob(root.left), rob(root.right), ... etc. From the point
        of view of the tree root, there are only two scenarios at the end: root is robbed or is not. If it is, due to
        the constraint that "we cannot rob any two directly-linked houses", the next level of subtrees that are
        available would be the four "grandchild-subtrees" (root.left.left, root.left.right, root.right.left, root
        .right.right). However if root is not robbed, the next level of available subtrees would just be the two
        "child-subtrees" (root.left, root.right). We only need to choose the scenario which yields the larger amount
        of money.

    TLE
 */
public class Solution {
    public int rob(TreeNode root) {
        if (root == null) return 0;
        int result = 0;

        if (root.left != null)
            result += rob(root.left.left) + rob(root.left.right);

        if (root.right != null)
            result += rob(root.right.left) + rob(root.right.right);

        return Math.max(result + root.val, rob(root.left) + rob(root.right));
    }
}
