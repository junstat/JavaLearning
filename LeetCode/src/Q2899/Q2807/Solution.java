package Q2899.Q2807;

import DataStructure.ListNode;

public class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode cur = head;
        while (cur.next != null) {
            ListNode g = new ListNode(gcd(cur.val, cur.next.val), cur.next);
            cur.next = g;
            cur = cur.next.next;
        }
        return head;
    }

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
