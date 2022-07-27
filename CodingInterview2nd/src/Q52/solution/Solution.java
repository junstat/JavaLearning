package Q52.solution;

import DataStructure.ListNode;

public class Solution {
    public ListNode FindFirstCommonNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA != null ? pA.next : headB;
            pB = pB != null ? pB.next : headA;
        }
        return pA;
    }
}
