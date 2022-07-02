package Q0199.Q0109ConvertSortedListtoBinarySearchTree;

import DataStructure.ListNode;
import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    List<Integer> nums = new ArrayList<>();

    // 方法一: 遍历链表将val保存到 array，套用Q 108
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        return build(0, nums.size() - 1);
    }

    TreeNode build(int left, int right) {
        if (left > right) return null;

        // 总是选择中间位置右边的数字作为根节点
        int mid = (left + right + 1) / 2;

        TreeNode root = new TreeNode(nums.get(mid));
        root.left = build(left, mid - 1);
        root.right = build(mid + 1, right);
        return root;
    }
}
