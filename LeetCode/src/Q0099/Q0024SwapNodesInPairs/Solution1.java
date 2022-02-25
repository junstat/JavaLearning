package Q0099.Q0024SwapNodesInPairs;

import DataStructure.ListNode;

public class Solution1 {
    /*
      recursion
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode suc = head.next;
        head.next = swapPairs(suc.next);
        suc.next = head;
        return suc;
    }
}
