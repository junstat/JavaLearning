package Q0599.Q0589NAryTreePreorderTraversal.solution2;

import Q0599.Q0559MaximumDepthofNAryTree.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        Deque<Object[]> d = new ArrayDeque<>();
        d.addLast(new Object[]{root, 0});
        while (!d.isEmpty()) {
            Object[] poll = d.pollLast();
            Node t = (Node) poll[0];
            Integer cnt = (Integer) poll[1];
            if (t == null) continue;
            if (cnt == 0) ans.add(t.val);
            if (cnt < t.children.size()) {
                d.addLast(new Object[]{t, cnt + 1});
                d.addLast(new Object[]{t.children.get(cnt), 0});
            }
        }
        return ans;
    }
}