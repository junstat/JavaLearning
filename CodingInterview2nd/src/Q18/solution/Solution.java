package Q18.solution;

import DataStructure.ListNode;

public class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        for (ListNode pre = dummy, cur = head; cur != null; cur = cur.next) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
        }
        return dummy.next;
    }
}
