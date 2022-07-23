package Q0299.Q0203RemoveLinkedListElements.solution2;

import DataStructure.ListNode;

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) return removeElements(head.next, val);
        else {
            head.next = removeElements(head.next, val);
            return head;
        }
    }
}
