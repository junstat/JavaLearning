package Q22.solution;

import DataStructure.ListNode;

public class Solution {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k < 1) return null;
        ListNode fast = head;
        while (k-- > 1) {
            if (fast.next == null) return null;
            fast = fast.next;
        }

        ListNode slow = head;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
