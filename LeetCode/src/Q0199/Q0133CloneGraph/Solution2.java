package Q0199.Q0133CloneGraph;

import java.util.*;

/*
    BFS:
 */
public class Solution2 {

    private Map<Node, Node> copies = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Node copy = new Node(node.val, new ArrayList<>());
        copies.put(node, copy);

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (Node neighbor : cur.neighbors) {
                if (!copies.containsKey(neighbor)) {
                    copies.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    queue.add(neighbor);
                }
                copies.get(cur).neighbors.add(copies.get(neighbor));
            }
        }
        return copy;
    }
}
