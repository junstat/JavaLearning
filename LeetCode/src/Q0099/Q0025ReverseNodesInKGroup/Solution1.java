package Q0099.Q0025ReverseNodesInKGroup;

import DataStructure.ListNode;

public class Solution1 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;
        ListNode dummy = new ListNode(0, head);
        int len = 1;
        while (head.next != null) { // 求链表长度
            head = head.next;
            len++;
        }

        ListNode pre = dummy;
        for (int start = 0; start + k <= len; start += k) {  // 以k为步长，每次处理[start, start+k]段链表
            ListNode cur = pre.next, rear = cur.next;
            for (int i = 1; i < k; i++) { // 组内元素反转
                cur.next = rear.next;
                rear.next = pre.next;
                pre.next = rear;
                rear = cur.next;
            }
            pre = cur;
        }
        return dummy.next;
    }
}
