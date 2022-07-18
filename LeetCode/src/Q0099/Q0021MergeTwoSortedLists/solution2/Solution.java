package Q0099.Q0021MergeTwoSortedLists.solution2;

import DataStructure.ListNode;

public class Solution {
    // 迭代
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return l1 != null ? l1 : l2;
        ListNode dummy = new ListNode(0), p = dummy;
        while (l1 != null && l2 != null) {     // 进入循环的条件是 与，不然，把非空的链表挂到结果链
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        p.next = l1 != null ? l1 : l2;
        return dummy.next;
    }
}