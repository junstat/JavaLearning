package Q0099.Q0024SwapNodesInPairs.solution2;

import DataStructure.ListNode;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        for (ListNode cur = dummy; cur.next != null && cur.next.next != null; ) {
            ListNode a = cur.next, b = a.next;
            cur.next = b;
            a.next = b.next;
            b.next = a;
            cur = a;
        }
        return dummy.next;
    }
}