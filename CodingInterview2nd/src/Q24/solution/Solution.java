package Q24.solution;

import DataStructure.ListNode;

public class Solution {
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre, p = head, r = p.next;
        p.next = null;
        while (r != null) {
            pre = p;
            p = r;
            r = r.next;
            p.next = pre;
        }
        return p;
    }
}
