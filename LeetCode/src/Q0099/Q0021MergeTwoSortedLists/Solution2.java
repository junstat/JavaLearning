package Q0099.Q0021MergeTwoSortedLists;

import DataStructure.ListNode;

public class Solution2 {
    /**
     * 迭代
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return l1 != null ? l1 : l2;
        ListNode head = new ListNode(0); // 头结点
        ListNode p = head;
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
        return head.next;
    }
}
