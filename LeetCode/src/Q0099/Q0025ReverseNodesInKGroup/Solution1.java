package Q0099.Q0025ReverseNodesInKGroup;

import DataStructure.ListNode;

public class Solution1 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur != null) {
            reverse(cur, k);
            int u = k;
            while (u-- > 0 && cur != null) cur = cur.next;
        }
        return dummy.next;
    }

    // reverse 的作用是将 root 后面的 k 个节点进行翻转
    void reverse(ListNode root, int k) {
        // 检查 root 后面是否有 k 个节点
        int u = k;
        ListNode cur = root;
        while (u-- > 0 && cur != null) cur = cur.next;
        if (cur == null) return;

        // 进行翻转
        ListNode tail = cur.next;
        ListNode a = root.next, b = a.next;
        // 当需要翻转 k 个节点时，中间就有 k - 1 个 next 指针需要翻转
        while (k-- > 1) {
            ListNode c = b.next;
            b.next = a;
            a = b;
            b = c;
        }
        root.next.next = tail;
        root.next = a;
    }
}