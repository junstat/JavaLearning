package Q0099.Q0024SwapNodesInPairs;

import DataStructure.ListNode;
import Utils.ListNodes;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You must solve the problem without modifying the values in the list's
 * nodes (i.e., only nodes themselves may be changed.)
 * <p>
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
 */
public class Review {
    @Test
    public void test1() {
        ListNode head = ListNodes.createListFromArray(new int[]{1, 2, 3, 4});
        ListNode expected = ListNodes.createListFromArray(new int[]{2, 1, 4, 3});
        assertEquals(swapPairs(head), expected);
    }

    public ListNode swapPairs(ListNode head) {

        return null;
    }
}
