package Q0099.Q0002AddTwoNumbers.solution1;

import DataStructure.ListNode;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);  // 挂头结点
        int sum = 0;
        ListNode cur = dummy;
        ListNode p1 = l1, p2 = l2;
        while (p1 != null || p2 != null) {
            int n1 = p1 != null ? p1.val : 0;
            int n2 = p2 != null ? p2.val : 0;
            sum = n1 + n2 + sum;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            sum /= 10;
            if (p1 != null) p1 = p1.next;
            if (p2 != null) p2 = p2.next;
        } // end of while loop
        if (sum != 0) cur.next = new ListNode(sum);
        return dummy.next;
    }
}
