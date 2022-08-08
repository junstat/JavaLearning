package Q0399.Q0337HouseRobberIII.solution3;

import DataStructure.TreeNode;

public class Solution {
    public int rob(TreeNode root) {
        int[] res = robAux(root);
        return Math.max(res[0], res[1]);
    }

    /**
     * 设返回值 为ans，ans[0]定义为不偷root，获得的最大收益；ans[1]定义为偷root获得的最大收益。
     *
     * @param root
     * @return
     */
    int[] robAux(TreeNode root) {
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
