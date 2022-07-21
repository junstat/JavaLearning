package Q0199.Q0108ConvertSortedArraytoBinarySearchTree.solution;

import DataStructure.TreeNode;

public class Solution {
    int[] nums;

    public TreeNode sortedArrayToBST(int[] _nums) {
        nums = _nums;
        return build(0, nums.length - 1);
    }

    TreeNode build(int left, int right) {
        if (left > right) return null;
        // 总是选择中间位置右边的数字作为根节点
        int mid = (left + right + 1) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(left, mid - 1);
        root.right = build(mid + 1, right);
        return root;
    }
}

