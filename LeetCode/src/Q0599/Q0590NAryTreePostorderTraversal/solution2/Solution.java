package Q0599.Q0590NAryTreePostorderTraversal.solution2;

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
            Integer cnt = (Integer) poll[0];
            Node t = (Node) poll[1];
            if (t == null) continue;
            if (cnt == t.children.size()) ans.add(t.val);
            if (cnt < t.children.size()) {
                d.addLast(new Object[]{cnt + 1, t});
                d.addLast(new Object[]{0, t.children.get(cnt)});
            }
        }
        return ans;
    }
}