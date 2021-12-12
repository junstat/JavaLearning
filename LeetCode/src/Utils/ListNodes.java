package Utils;

import DataStructure.ListNode;

public class ListNodes {

    public static ListNode createListFromArray(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode p = head;
        for (int i = 1; i < arr.length; i++) {
            p.next = new ListNode(arr[i]);
            p = p.next;
        }
        return head;
    }

    public static void printList(ListNode head) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        ListNode p = head;
        while (p != null) {
            System.out.print(p.val + "  ");
            p = p.next;
        }
        System.out.println();
    }

    public static void printList(String hint, ListNode head) {
        System.out.println(hint);
        ListNodes.printList(head);
    }
}
