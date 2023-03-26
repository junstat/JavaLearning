package Q2399.Q2395FindSubarraysWithEqualSum.solution;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean findSubarrays(int[] nums) {
        int n = nums.length;
        if (n <= 2) return false;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n - 1; i++) {
            int sum = nums[i] + nums[i + 1];
            if (set.contains(sum)) return true;
            set.add(sum);
        }
        return false;
    }
}
