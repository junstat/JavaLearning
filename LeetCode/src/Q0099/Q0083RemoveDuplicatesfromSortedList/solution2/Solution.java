package Q0099.Q0083RemoveDuplicatesfromSortedList.solution2;

import DataStructure.ListNode;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }
}
