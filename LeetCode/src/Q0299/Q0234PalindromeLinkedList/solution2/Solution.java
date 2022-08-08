package Q0299.Q0234PalindromeLinkedList.solution2;

import DataStructure.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public boolean isPalindrome(ListNode head) {
        Deque<ListNode> d = new ArrayDeque<>();
        for (ListNode p = head; p != null; p = p.next) d.addLast(p);
        for (ListNode p = head; p != null && !d.isEmpty(); p = p.next) {
            ListNode q = d.peekLast();
            if (q.val != p.val) return false;
            d.pollLast();
        }
        return true;
    }
}