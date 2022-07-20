package Q0099.Q0025ReverseNodesInKGroup.review;

import DataStructure.ListNode;
import Utils.ListNodes;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
  [Hard]
  Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
  k is a positive integer and is less than or equal to the length of the linked list.
  If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
  You may not alter the values in the list's nodes, only nodes themselves may be changed.

  Input: head = [1,2,3,4,5], k = 2
  Output: [2,1,4,3,5]
 */
public class Solution {

    @Test
    public void test1() {
        ListNode head = ListNodes.createListFromArray(new int[]{1, 2, 3, 4, 5});
        ListNode expected = ListNodes.createListFromArray(new int[]{2, 1, 4, 3, 5});
        assertEquals(reverseKGroup(head, 2), expected);
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        return null;
    }
}
