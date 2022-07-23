package Q0599.Q0590NAryTreePostorderTraversal.solution3;

import Q0599.Q0559MaximumDepthofNAryTree.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        Deque<Object[]> d = new ArrayDeque<>();
        d.addLast(new Object[]{0, root});
        while (!d.isEmpty()) {
            Object[] poll = d.pollLast();
            Integer loc = (Integer) poll[0];
            Node t = (Node) poll[1];
            if (t == null) continue;
            if (loc == 0) {
                d.addLast(new Object[]{1, t});
                int n = t.children.size();
                for (int i = n - 1; i >= 0; i--) d.addLast(new Object[]{0, t.children.get(i)});
            } else if (loc == 1) {
                ans.add(t.val);
            }
        }
        return ans;
    }
}