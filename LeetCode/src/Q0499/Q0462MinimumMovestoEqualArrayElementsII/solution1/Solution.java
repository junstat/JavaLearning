package Q0499.Q0462MinimumMovestoEqualArrayElementsII.solution1;

import java.util.Arrays;

public class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, t = nums[(n - 1) / 2], ans = 0;
        for (int i : nums) ans += Math.abs(t - i);
        return ans;
    }
}