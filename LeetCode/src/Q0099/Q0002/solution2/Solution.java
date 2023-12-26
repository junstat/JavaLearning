package Q0099.Q0002.solution2;

import DataStructure.ListNode;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        addTwoNumbersAux(l1, l2, dummy, 0);
        return dummy.next;
    }

    private void addTwoNumbersAux(ListNode p1, ListNode p2, ListNode cur, int sum) {
        if (p1 != null || p2 != null) {
            int n1 = p1 != null ? p1.val : 0;
            int n2 = p2 != null ? p2.val : 0;
            sum = n1 + n2 + sum;
            cur.next = new ListNode(sum % 10);
            addTwoNumbersAux(p1 == null ? null : p1.next, p2 == null ? null : p2.next, cur.next, sum / 10);
        } else if (sum != 0) cur.next = new ListNode(sum);
    }
}
