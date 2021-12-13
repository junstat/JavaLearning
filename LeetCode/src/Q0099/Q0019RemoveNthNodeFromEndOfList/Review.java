package Q0099.Q0019RemoveNthNodeFromEndOfList;

import DataStructure.ListNode;
import Utils.ListNodes;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
