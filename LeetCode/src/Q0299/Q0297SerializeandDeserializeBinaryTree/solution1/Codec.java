package Q0299.Q0297SerializeandDeserializeBinaryTree.solution1;

import DataStructure.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder ans = serializeAux(new StringBuilder(), root);
        return ans.toString();
    }

    // Generate preorder string
    StringBuilder serializeAux(StringBuilder s, TreeNode root) {
        if (root == null) return s.append('#');
        s.append(root.val).append(',');
        serializeAux(s, root.left).append(',');
        serializeAux(s, root.right);
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return deserializeAux(new LinkedList<>(Arrays.asList(data.split(","))));
    }

    TreeNode deserializeAux(Queue<String> q) {
        String val = q.poll();
        if ("#".equals(val)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = deserializeAux(q);
        root.right = deserializeAux(q);
        return root;
    }
}