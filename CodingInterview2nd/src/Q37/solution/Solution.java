package Q37.solution;

import DataStructure.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    String Serialize(TreeNode root) {
        return serializeAux(new StringBuilder(), root).toString();
    }

    StringBuilder serializeAux(StringBuilder str, TreeNode root) {
        if (root == null) return str.append('#');
        str.append(root.val).append(',');
        serializeAux(str, root.left).append(',');
        serializeAux(str, root.right);
        return str;
    }

    TreeNode Deserialize(String str) {
        return deserializeAux(new LinkedList<>(Arrays.asList(str.split(","))));
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