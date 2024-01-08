package Q0199.Q0114.solution1;

import DataStructure.TreeNode;

/*
    recursion
    思路: 先序遍历, 根左右 即为结果
    因为预期的目标是用树的right域充当链表的next域，故从右子树出发，每次寻找前驱。
 */
public class Solution {
    TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}

/*
示例:
    1
   / \
  2   5
 / \   \
3   4   6
-----------
pre = 5
cur = 4

    1
   /
  2
 / \
3   4
     \
      5
       \
        6
-----------
pre = 4
cur = 3

    1
   /
  2
 /
3
 \
  4
   \
    5
     \
      6
-----------
cur = 2
pre = 3

    1
   /
  2
   \
    3
     \
      4
       \
        5
         \
          6
-----------
cur = 1
pre = 2

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
 */