package Q0099.Q0024SwapNodesInPairs;

import DataStructure.ListNode;

public class Solution1 {
    /**
     * iteration
     * 后继: successor
     * pre->cur->suc->rear ==> pre->suc->cur->rear
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head), pre = dummy;
        while (pre.next != null && pre.next.next != null) {
            ListNode cur = pre.next, suc = cur.next, rear = suc.next;
            pre.next = suc;
            suc.next = cur;
            cur.next = rear;
            pre = cur;
        }
        return dummy.next;
    }
}
