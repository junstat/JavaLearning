package Q0099.Q0023.review;

import DataStructure.ListNode;
import Utils.ListNodes;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
  [Hard]
  You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

  Merge all the linked-lists into one sorted linked-list and return it.

  Input: lists = [[1,4,5],[1,3,4],[2,6]]
  Output: [1,1,2,3,4,4,5,6]
  Explanation: The linked-lists are:
  [
  1->4->5,
  1->3->4,
  2->6
  ]
  merging them into one sorted list:
  1->1->2->3->4->4->5->6
 */
public class Solution {
    @Test
    public void test1() {
        ListNode l1 = ListNodes.createListFromArray(new int[]{1, 4, 5});
        ListNode l2 = ListNodes.createListFromArray(new int[]{1, 3, 4});
        ListNode l3 = ListNodes.createListFromArray(new int[]{2, 6});
        ListNode[] lists = new ListNode[]{l1, l2, l3};
        ListNode expected = ListNodes.createListFromArray(new int[]{1, 1, 2, 3, 4, 4, 5, 6});
        assertEquals(expected, mergeKLists(lists));
    }

    public ListNode mergeKLists(ListNode[] lists) {

        return null;
    }
}
