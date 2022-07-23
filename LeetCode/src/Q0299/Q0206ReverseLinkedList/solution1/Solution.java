package Q0299.Q0206ReverseLinkedList.solution1;

import DataStructure.ListNode;

public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode p, r;  // p 为工作指针，r为p后继，防断链
        p = head;
        ListNode dummy = new ListNode(0);
        while (p != null) {
            r = p.next;
            p.next = dummy.next;
            dummy.next = p;
            p = r;
        }
        return dummy.next;
    }
}
