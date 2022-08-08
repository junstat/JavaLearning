package Q0299.Q0297SerializeandDeserializeBinaryTree.solution2;

import DataStructure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Codec {
    int INF = -2000;
    TreeNode emptyNode = new TreeNode(INF);

    public String serialize(TreeNode root) {
        if (root == null) return "";

        StringBuilder sb = new StringBuilder();
        Deque<TreeNode> d = new ArrayDeque<>();
        d.addLast(root);
        while (!d.isEmpty()) {
            TreeNode poll = d.pollFirst();
            sb.append(poll.val + "_");
            if (!poll.equals(emptyNode)) {
                d.addLast(poll.left != null ? poll.left : emptyNode);
                d.addLast(poll.right != null ? poll.right : emptyNode);
            }
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;

        String[] ss = data.split("_");
        int n = ss.length;
        TreeNode root = new TreeNode(Integer.parseInt(ss[0]));
        Deque<TreeNode> d = new ArrayDeque<>();
        d.addLast(root);
        for (int i = 1; i < n - 1; i += 2) {
            TreeNode poll = d.pollFirst();
            int a = Integer.parseInt(ss[i]), b = Integer.parseInt(ss[i + 1]);
            if (a != INF) {
                poll.left = new TreeNode(a);
                d.addLast(poll.left);
            }
            if (b != INF) {
                poll.right = new TreeNode(b);
                d.addLast(poll.right);
            }
        }
        return root;
    }
}