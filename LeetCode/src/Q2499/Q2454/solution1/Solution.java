package Q2499.Q2454.solution1;

import org.junit.Test;

import java.util.Arrays;

public
class Solution {
    @Test
    public void test1() {
        int[] nums = {2, 4, 0, 9, 6};
        System.out.println(Arrays.toString(secondGreaterElement(nums)));
    }

    public int[] secondGreaterElement(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);

        ListNode head = new ListNode(0, 0, null);
        for (int i = 0; i < n; ++i) {
            ListNode prev = head, cur = head.next;
            while (cur != null && cur.value < nums[i]) {
                if (++cur.count > 1) {
                    result[cur.index] = nums[i];
                    prev.next = cur.next;
                } else {
                    prev = cur;
                }
                cur = cur.next;
            }
            prev.next = new ListNode(i, nums[i], cur);
        }
        return result;
    }

    static class ListNode {
        int index, value, count;
        ListNode next;

        ListNode(int index, int value, ListNode next) {
            this.index = index;
            this.value = value;
            this.next = next;

        }
    }
}
