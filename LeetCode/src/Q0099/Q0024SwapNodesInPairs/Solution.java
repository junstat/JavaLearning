package Q0099.Q0024SwapNodesInPairs;

import DataStructure.ListNode;
import Utils.ListNodes;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution {
    /**
     * recursion
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode suc = head.next;
        head.next = swapPairs(suc.next);
        suc.next = head;
        return suc;
    }
}
