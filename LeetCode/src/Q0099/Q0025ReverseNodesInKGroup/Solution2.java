package Q0099.Q0025ReverseNodesInKGroup;

import DataStructure.ListNode;

public class Solution2 {
    public ListNode reverseKGroup(ListNode head, int k) {
        int u = k;
        ListNode p = head;
        while (p != null && u-- > 1) p = p.next;
        if (p == null) return head;

        ListNode tail = head;
        ListNode prev = head, cur = prev.next;
        u = k;
        while (u-- > 1) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        tail.next = reverseKGroup(cur, k);
        return prev;
    }
}