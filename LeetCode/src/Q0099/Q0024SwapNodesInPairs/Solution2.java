package Q0099.Q0024SwapNodesInPairs;

import DataStructure.ListNode;
import Utils.ListNodes;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution2 {
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

    @Test
    public void test1() {
        ListNode head = ListNodes.createListFromArray(new int[]{1, 2, 3, 4});
        ListNode expected = ListNodes.createListFromArray(new int[]{2, 1, 4, 3});
        assertEquals(swapPairs(head), expected);
    }
}
