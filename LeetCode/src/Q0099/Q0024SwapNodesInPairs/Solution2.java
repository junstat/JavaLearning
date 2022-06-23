package Q0099.Q0024SwapNodesInPairs;

import DataStructure.ListNode;

public class Solution2 {
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