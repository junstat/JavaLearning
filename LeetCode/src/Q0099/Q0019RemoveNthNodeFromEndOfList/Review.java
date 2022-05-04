package Q0099.Q0019RemoveNthNodeFromEndOfList;

import DataStructure.ListNode;
import Utils.ListNodes;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
  [Medium]
  Given the head of a linked list, remove the nth node from the end of the list and return its head.
  Input: head = [1,2,3,4,5], n = 2
  Output: [1,2,3,5]
  核心思路: 找到倒数第n个结点的前驱pre(倒数n+1)， pre.next = pre.next.next 即可
  以 n = 2
  dummy: 0 | 1 2 3 4 5   为例
         s   f
 */
public class Review {
    @Test
    public void test1() {
        ListNode head = ListNodes.createListFromArray(new int[]{1, 2, 3, 4, 5});
        ListNode expected = ListNodes.createListFromArray(new int[]{1, 2, 3, 5});
        assertEquals(removeNthFromEnd(head, 2), expected);
    }

    @Test
    public void test2() {
        ListNode head = ListNodes.createListFromArray(new int[]{1, 2});
        ListNode expected = ListNodes.createListFromArray(new int[]{1});
        assertEquals(removeNthFromEnd(head, 1), expected);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        return null;
    }
}
