package Q23.solution;

import DataStructure.ListNode;

public class Solution {
    public ListNode EntryNodeOfLoop(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next == null) return null;
            fast = fast.next.next;
            if (fast == slow) {
                ListNode p = head;
                while (p != slow) {
                    p = p.next;
                    slow = slow.next;
                }
                return p;
            }
        }
        return null;
    }
}
