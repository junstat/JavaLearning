package Q0299.Q0297SerializeandDeserializeBinaryTree;

import DataStructure.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
}

/*
    The idea is simple: print the tree in pre-order traversal and use "X" to denote null node and split node with ",".
    We can use a StringBuilder for building the string on the fly. For deserializing, we use a Queue to store the
    pre-order traversal and since we have "X" as null node, we know exactly how to where to end building subtress.
 */
class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serializeAux(new StringBuilder(), root).toString();
    }

    // Generate preorder string
    private StringBuilder serializeAux(StringBuilder str, TreeNode root) {
        if (root == null) return str.append("#");
        str.append(root.val).append(",");
        serializeAux(str, root.left).append(",");
        serializeAux(str, root.right);
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return deserializeAux(new LinkedList<>(Arrays.asList(data.split(","))));
    }

    private TreeNode deserializeAux(Queue<String> q) {
        String val = q.poll();
        if ("#".equals(val)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = deserializeAux(q);
        root.right = deserializeAux(q);
        return root;
    }
}