package Q0099.Q0019RemoveNthNodeFromEndOfList.solution;

import DataStructure.ListNode;

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head), fast = dummy, slow = dummy;
        while (n-- > 0) fast = fast.next;
        while (fast.next != null) { // 找前驱
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}