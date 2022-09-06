package Q0899.Q0817LinkedListComponents.solution;

import DataStructure.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> setG = new HashSet<>();
        for (int i : nums) setG.add(i);
        int ans = 0;
        while (head != null) {
            if (setG.contains(head.val) && (head.next == null || !setG.contains(head.next.val))) ans++;
            head = head.next;
        }
        return ans;
    }
}