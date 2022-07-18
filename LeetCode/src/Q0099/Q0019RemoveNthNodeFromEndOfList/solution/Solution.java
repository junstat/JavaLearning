package Q0099.Q0019RemoveNthNodeFromEndOfList.solution;

import DataStructure.ListNode;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) return null;
        ListNode slow = head, fast = head;
        while (n-- > 0) fast = fast.next;

        if (fast == null) head = slow.next;
        else {
            while (fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }
            slow.next = slow.next.next;
        }
        return head;
    }
}