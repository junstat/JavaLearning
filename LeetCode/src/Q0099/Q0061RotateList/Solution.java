package Q0099.Q0061RotateList;

import DataStructure.ListNode;

/*
  找到倒数第k个结点的前驱 pre，把pre之后的所有结点从链表中取下，插入到头部。
  如: 1 -> 2 -> 3 -> 4 -> 5 -> null, k = 2
  倒数第2个结点为4，其前驱为3，把 4 -> 5 -> null 从链表上取下，插入到头部
  4 -> 5 -> 1 -> 2 -> 3 -> null
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        int len = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }
        k %= len;
        if (k == 0) return head;

        ListNode pre = head;
        while (--len > k) pre = pre.next;  // 找到倒数第k个结点的前驱
        ListNode newHead = pre.next;
        tail.next = head;
        pre.next = null;
        return newHead;
    }
}
