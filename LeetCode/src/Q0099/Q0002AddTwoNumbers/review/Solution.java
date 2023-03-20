package Q0099.Q0002AddTwoNumbers.review;

import DataStructure.ListNode;
import Utils.ListNodes;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution {

    @Test
    public void test1() {
        ListNode l1 = ListNodes.createListFromArray(new int[]{2, 4, 3});
        ListNode l2 = ListNodes.createListFromArray(new int[]{5, 6, 4});
        ListNode expect = ListNodes.createListFromArray(new int[]{7, 0, 8});
        assertEquals(expect, addTwoNumbers(l1, l2));
    }

    @Test
    public void test2() {
        ListNode l1 = ListNodes.createListFromArray(new int[]{9, 9, 9, 9, 9, 9, 9});
        ListNode l2 = ListNodes.createListFromArray(new int[]{9, 9, 9, 9});
        ListNode expect = ListNodes.createListFromArray(new int[]{8, 9, 9, 9, 0, 0, 0, 1});
        assertEquals(expect, addTwoNumbers(l1, l2));
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        var p = l1;
        var q = l2;
        var dummy = new ListNode(0);
        var tail = dummy;
        var c = 0;
        while (p != null || q != null) {
            var a = p != null ? p.val : 0;
            var b = q != null ? q.val : 0;
            c = a + b + c;
            tail.next = new ListNode(c % 10);
            tail = tail.next;
            c /= 10;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (c != 0) tail.next = new ListNode(c);
        return dummy.next;
    }


}
