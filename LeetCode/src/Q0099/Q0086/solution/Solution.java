package Q0099.Q0086.solution;

import DataStructure.ListNode;

public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(0), l = left, right = new ListNode(0), r = right;
        while (head != null) {
            if (head.val < x) {
                l.next = head;
                l = l.next;
            } else {
                r.next = head;
                r = r.next;
            }
            head = head.next;
        }
        r.next = null;
        l.next = right.next;
        return left.next;
    }
}
