package Q0099.Q0099.summary;

import DataStructure.TreeNode;
import org.junit.Test;

public class MorrisInOrderTraversal {
    @Test
    public void test1() {
        TreeNode r1 = new TreeNode(4, new TreeNode(3), new TreeNode(5));
        TreeNode l1 = new TreeNode(1);
        TreeNode l2 = new TreeNode(2, l1, r1);
        TreeNode r2 = new TreeNode(7, null, new TreeNode(9, new TreeNode(8), null));
        TreeNode root = new TreeNode(6, l2, r2);
        morrisTraversal(root);
    }

    // Morris Inorder Traversal
    public void morrisTraversal(TreeNode root) {
        TreeNode cur = root, pre = null;
        while (cur != null) {
            if (cur.left != null) {
                pre = cur.left;
                // find predecessor
                while (pre.right != null && pre.right != cur)
                    pre = pre.right;
                if (pre.right == null) {    // create thread
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    System.out.print(cur.val + " ");
                    pre.right = null;
                    cur = cur.right;
                }
            } else {
                System.out.print(cur.val + " ");
                cur = cur.right;
            }
        }
    }
}
