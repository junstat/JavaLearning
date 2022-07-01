package Q0099.Q0083RemoveDuplicatesfromSortedList;

import DataStructure.ListNode;

public class Solution1 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode dummy = new ListNode(-109);
        ListNode tail = dummy;
        while (head != null) {
            // 值不相等才追加，确保了相同的节点只有第一个会被添加到答案
            if (tail.val != head.val) {
                tail.next = head;
                tail = tail.next;
            }
            head = head.next;
        }
        tail.next = null;
        return dummy.next;
    }
}