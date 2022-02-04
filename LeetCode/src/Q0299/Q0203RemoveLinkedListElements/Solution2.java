package Q0299.Q0203RemoveLinkedListElements;

import DataStructure.ListNode;

// Recursive
public class Solution2 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) return removeElements(head.next, val);
        else {
            head.next = removeElements(head.next, val);
            return head;
        }
    }
}
