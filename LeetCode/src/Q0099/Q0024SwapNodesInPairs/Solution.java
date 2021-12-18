package Q0099.Q0024SwapNodesInPairs;

import DataStructure.ListNode;
import Utils.ListNodes;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution {
    /*
       1、给定两个结点: pre, p(其中，pre是p的前驱)，逆转操作: pre->next = p->next; p -> next = pre;
       2、遍历链表，工作指针为cur用以标记当前遍历位置，保证cur后有2个结点则执行1、操作。
       3、注意，当逆转完成时，pre,p的相对位置关系已逆转，p为pre前驱。故，为保证不断链，
          cur的后继为p,pre中的相对位置靠前的那个(逆转完成后为p) cur->next = p;
          cur后移处理下一对Pairs: cur= pre;
        cur->pre->p->....  ==> cur->p->pre->....
    */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;

        while (cur.next != null && cur.next.next != null) {
            ListNode pre = cur.next;
            ListNode p = pre.next;

            pre.next = p.next;  // step 1.
            p.next = pre;

            cur.next = p;  // step 3.
            cur = pre;
        }
        return dummy.next;
    }

    @Test
    public void test1() {
        ListNode head = ListNodes.createListFromArray(new int[]{1, 2, 3, 4});
        ListNode expected = ListNodes.createListFromArray(new int[]{2, 1, 4, 3});
        assertEquals(swapPairs(head), expected);
    }
}
