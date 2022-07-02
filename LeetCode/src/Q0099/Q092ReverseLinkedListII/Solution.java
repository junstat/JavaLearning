package Q0099.Q092ReverseLinkedListII;

import DataStructure.ListNode;

class Solution {
    public ListNode reverseBetween(ListNode head, int l, int r) {
        ListNode dummy = new ListNode(0, head);
        r -= l; // r - l 个node需要反转

        ListNode hh = dummy;
        while (l-- > 1) hh = hh.next;

        ListNode a = hh.next, b = a.next;
        while (r-- > 0) {
            ListNode tmp = b.next;  // 防断链
            b.next = a;
            a = b;
            b = tmp;
        }

        hh.next.next = b;
        hh.next = a;
        return dummy.next;
    }
}