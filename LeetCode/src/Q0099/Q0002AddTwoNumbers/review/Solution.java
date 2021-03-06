package Q0099.Q0002AddTwoNumbers.review;

import DataStructure.ListNode;
import Utils.ListNodes;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
   [Medium]
   You are given two non-empty linked lists representing two non-negative integers.
   The digits are stored in reverse order, and each of their nodes contains a single digit.
   Add the two numbers and return the sum as a linked list.

   You may assume the two numbers do not contain any leading zero, except the number 0 itself.

   Input: l1 = [2,4,3], l2 = [5,6,4]
   Output: [7,0,8]
   Explanation: 342 + 465 = 807.

   分析:
   假设l1, l2均为3位数，对于阅读顺序: 百位、十位、个位，链表存储顺序: 个位、十位、百位，计算顺序与链表存储顺序一致，
   故遍历链表，设置进位即可。
 */
public class Solution{

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

        return null;
    }
}
