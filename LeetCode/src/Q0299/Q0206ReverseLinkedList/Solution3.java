package Q0299.Q0206ReverseLinkedList;

import DataStructure.ListNode;

/*
   method 3: recursive solution
 */
public class Solution3 {
    public ListNode reverseList(ListNode head) {
        return reverseListAux(head, null);
    }

    private ListNode reverseListAux(ListNode p, ListNode pre) {
        if (p == null) return pre;
        ListNode r = p.next;
        p.next = pre;
        return reverseListAux(r, p);
    }
}
