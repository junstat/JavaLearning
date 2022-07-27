package Q35.solution;

import DataStructure.RandomListNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public RandomListNode Clone(RandomListNode head) {
        if (head == null) return null;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();

        // loop 1. copy all the nodes
        for (RandomListNode p = head; p != null; p = p.next)
            map.put(p, new RandomListNode(p.label));

        // loop 2. assign next and random pointers
        for (RandomListNode p = head; p != null; p = p.next) {
            map.get(p).next = map.get(p.next);
            map.get(p).random = map.get(p.random);
        }
        return map.get(head);
    }
}