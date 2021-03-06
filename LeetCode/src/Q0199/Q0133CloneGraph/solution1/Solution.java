package Q0199.Q0133CloneGraph.solution1;


import Q0199.Q0133CloneGraph.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    private Map<Integer, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (map.containsKey(node.val)) return map.get(node.val);

        Node newNode = new Node(node.val, new ArrayList<>());
        map.put(newNode.val, newNode);
        for (Node neighbor : node.neighbors)
            newNode.neighbors.add(cloneGraph(neighbor));
        return newNode;
    }
}
