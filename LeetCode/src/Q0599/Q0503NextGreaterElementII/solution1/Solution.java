package Q0599.Q0503NextGreaterElementII.solution1;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length, res[] = new int[n];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n * 2; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n])
                res[stack.pop()] = nums[i % n];
            stack.push(i % n);
        }
        return res;
    }
}