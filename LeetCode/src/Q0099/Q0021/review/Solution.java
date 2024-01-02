package Q0099.Q0021.review;

import DataStructure.ListNode;
import Utils.ListNodes;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
  [Easy]
  You are given the heads of two sorted linked lists list1 and list2.
  Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of
  the first two lists.

  Return the head of the merged linked list.
  Input: list1 = [1,2,4], list2 = [1,3,4]
  Output: [1,1,2,3,4,4]
 */
public class Solution {

    @Test
    public void test1() {
        ListNode l1 = ListNodes.createListFromArray(new int[]{1, 2, 4});
        ListNode l2 = ListNodes.createListFromArray(new int[]{1, 3, 4});
        ListNode expected = ListNodes.createListFromArray(new int[]{1, 1, 2, 3, 4, 4});
        assertEquals(mergeTwoLists(l1, l2), expected);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        return null;
    }
}
