package Q33.solution;

public class Solution {
    public boolean VerifySquenceOfBST(int[] sequence) {
        return VerifySquenceOfBST(sequence, 0, sequence.length - 1);
    }

    boolean VerifySquenceOfBST(int[] nums, int start, int end) {
        if (nums == null || end + 1 <= start) return false;
        int root = nums[end];
        // 在二叉搜索树左子树节点的值小于根节点的值
        int i = start;
        for (; i < end; i++) if (nums[i] > root) break;
        // 在二叉搜索树右子树节点的值大于根节点的值
        int j = i;
        for (; j < end; j++) if (nums[j] < root) return false;
        // 判断左子树是不是二叉搜索树
        boolean left = true;
        if (i > start) left = VerifySquenceOfBST(nums, start, i - 1);
        // 判断右子树是不是二叉搜索树
        boolean right = true;
        if (i < end) right = VerifySquenceOfBST(nums, i, end - 1);
        return left && right;
    }
}
