package Q0099.Q0024SwapNodesInPairs;

import DataStructure.ListNode;

public class Solution1 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        recursive(dummy);
        return dummy.next;
    }

    void recursive(ListNode root) {
        if (root.next != null && root.next.next != null) {
            ListNode a = root.next, b = a.next;
            root.next = b;
            a.next = b.next;
            b.next = a;
            recursive(a);
        }
    }
}