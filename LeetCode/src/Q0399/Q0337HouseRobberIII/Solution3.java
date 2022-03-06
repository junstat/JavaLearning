package Q0399.Q0337HouseRobberIII;

import DataStructure.TreeNode;

/*
    Step III -- Think one step back

    In step I, we defined our problem as rob(root), which will yield the maximum amount of money that can be robbed
    of the binary tree rooted at root. This leads to the DP problem summarized in step II.

    Now let's take one step back and ask why we have overlapping subproblems. If you trace all the way back to the
    beginning, you'll find the answer lies in the way how we have defined rob(root). As I mentioned, for each tree
    root, there are two scenarios: it is robbed or is not. rob(root) does not distinguish between these two cases, so
    information is lost as the recursion goes deeper and deeper", which results in repeated subproblems.

    If we were able to maintain the information about the two scenarios for each tree root, let's see how it plays
    out. Redefine rob(root) as a new function which will return an array of two elements, the first element of which
    denotes the maximum amount of money that can be robbed if root is not robbed, while the second element signifies
    the maximum amount of money robbed if it is robbed.

    Let's relate rob(root) to rob(root.left) and rob(root.right)..., etc. For the 1st element of rob(root), we only
    need to sum up the larger elements of rob(root.left) and rob(root.right), respectively, since root is not robbed
    and we are free to rob its left and right subtrees. For the 2nd element of rob(root), however, we only need to
    add up the 1st elements of rob(root.left) and rob(root.right), respectively, plus the value robbed from root
    itself, since in this case it's guaranteed that we cannot rob the nodes of root.left and root.right.

    As you can see, by keeping track of the information of both scenarios, we decoupled the subproblems and the
    solution essentially boiled down to a greedy one.
 */
public class Solution3 {
    public int rob(TreeNode root) {
        int[] res = robAux(root);
        return Math.max(res[0], res[1]);
    }

    private int[] robAux(TreeNode root) {
        if (root == null) return new int[2];
        int[] left = robAux(root.left);
        int[] right = robAux(root.right);
        int[] result = new int[2];

        // For the 1st element of rob(root), we only
        // need to sum up the larger elements of rob(root.left) and rob(root.right), respectively, since root is not
        // robbed and we are free to rob its left and right subtrees.
        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // For the 2nd element of rob(root), however, we only need to add up the 1st elements of rob(root.left) and
        // rob(root.right), respectively, plus the value robbed from root itself, since in this case it's guaranteed
        // that we cannot rob the nodes of root.left and root.right.
        result[1] = root.val + left[0] + right[0];

        return result;
    }
}
