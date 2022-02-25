package Q0099.Q0025ReverseNodesInKGroup;

import DataStructure.ListNode;

public class Solution2 {
    /*
      recursion
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        while (cur != null && count != k) { // find the k + 1 node
            cur = cur.next;
            count++;
        }

        if (count == k) {   // if k + 1 node is found
            cur = reverseKGroup(cur, k);       // reverse list with k+1 node as head
            while (count-- > 0) {       // reverse current k-group
                ListNode p = head.next;
                head.next = cur;
                cur = head;
                head = p;
            }
            head = cur;
        }
        return head;
    }
}
