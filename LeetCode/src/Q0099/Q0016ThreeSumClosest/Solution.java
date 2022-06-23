package Q0099.Q0016ThreeSumClosest;

import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int t) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(sum - t) < Math.abs(ans - t)) ans = sum;
                if (ans == t) return t;
                else if (sum > t) k--;
                else j++;
            }
        }
        return ans;
    }
}