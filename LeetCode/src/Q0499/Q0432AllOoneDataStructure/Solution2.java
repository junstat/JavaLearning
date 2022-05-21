package Q0499.Q0432AllOoneDataStructure;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
}

// Runtime: 39 ms, faster than 99.40% of Java online submissions for All O`one Data Structure.
class AllOne {
    Node head = null;
    Node tail = null;
    Map<String, Node> map = new HashMap<>();

    public AllOne() {
    }

    public void inc(String key) {
        Node node = map.get(key);
        if (node == null) {
            node = new Node();
            map.put(key, node);
            node.v = key;
            node.counts = 1;
            if (head == null) {
                head = node;
                tail = node;
            } else {
                head.left = node;
                node.right = head;
                head = node;
            }
        } else {
            node.counts++;
            while (tail != node && node.counts > node.right.counts) {
                swap(node, node.right);
            }
        }
    }

    public void dec(String key) {
        Node node = map.get(key);
        node.counts--;
        if (node.counts == 0) {
            map.remove(key);
            if (node.right != null) {
                node.right.left = node.left;
            }
            if (node.left != null) {
                node.left.right = node.right;
            }
            if (node == head) {
                head = node.right;
            }
            if (node == tail) {
                tail = node.left;
            }
        } else {
            while (head != node && node.counts < node.left.counts) {
                swap(node.left, node);
            }
        }
    }

    public String getMinKey() {
        if (head == null) {
            return "";
        }
        return head.v;
    }

    public String getMaxKey() {
        if (tail == null) {
            return "";
        }
        return tail.v;
    }

    private void swap(Node n1, Node n2) {
        Node left = n1.left;
        Node right = n2.right;
        if (left == null) {
            head = n2;
        } else {
            left.right = n2;
        }
        n2.left = left;
        if (right == null) {
            tail = n1;
        } else {
            right.left = n1;
        }
        n1.right = right;
        n1.left = n2;
        n2.right = n1;
    }
}

class Node {
    String v;
    int counts;
    Node left;
    Node right;
}

