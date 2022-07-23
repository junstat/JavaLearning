package Q0299.Q0203RemoveLinkedListElements.solution1;

import DataStructure.ListNode;

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            if (cur.val != val) {
                pre = cur;
            } else {
                if (cur == head) head = cur.next;  // 删除头结点
                else pre.next = cur.next;
            }
            cur = cur.next;
        }
        return head;
    }
}
