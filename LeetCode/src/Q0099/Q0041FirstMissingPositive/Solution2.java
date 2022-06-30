package Q0099.Q0041FirstMissingPositive;

import java.util.Arrays;

public class Solution2 {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 1; i <= n; i++) {
            if (Arrays.binarySearch(nums, i) < 0) return i;
        }
        return n + 1;
    }
}
