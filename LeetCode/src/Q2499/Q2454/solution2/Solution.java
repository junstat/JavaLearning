package Q2499.Q2454.solution2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {
    public int[] secondGreaterElement(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Deque<Integer> s1 = new ArrayDeque<>(),
                s2 = new ArrayDeque<>(),
                tmp = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!s2.isEmpty() && nums[s2.peekLast()] < nums[i])
                ans[s2.pollLast()] = nums[i];
            while (!s1.isEmpty() && nums[s1.peekLast()] < nums[i])
                tmp.addLast(s1.pollLast());
            while (!tmp.isEmpty())
                s2.addLast(tmp.pollLast());
            s1.addLast(i);
        }
        return ans;
    }
}
