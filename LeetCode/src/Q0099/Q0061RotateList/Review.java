package Q0099.Q0061RotateList;

import DataStructure.ListNode;
import Utils.ListNodes;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
  [Medium]
  Given the head of a linked list, rotate the list to the right by k places.

  Example 1:
  Input: head = [1,2,3,4,5], k = 2
  Output: [4,5,1,2,3]
 */
public class Review {

    @Test
    public void test1() {
        ListNode head = ListNodes.createListFromArray(new int[]{1, 2, 3, 4, 5});
        ListNode result = rotateRight(head, 2);
        ListNode expected = ListNodes.createListFromArray(new int[]{4, 5, 1, 2, 3});
        assertEquals(expected, result);
    }

    public ListNode rotateRight(ListNode head, int k) {

        return null;
    }
}
