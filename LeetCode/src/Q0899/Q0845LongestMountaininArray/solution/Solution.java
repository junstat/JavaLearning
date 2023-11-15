package Q0899.Q0845LongestMountaininArray.solution;

public class Solution {
    public int longestMountain(int[] nums) {
        if (nums == null || nums.length <= 2) return 0;
        int ans = 0, n = nums.length;
        for (int i = 1; i < n - 1; i++) {
            if (nums[i - 1] < nums[i] && nums[i + 1] < nums[i]) {
                int l = i - 1;
                int r = i + 1;
                while (l > 0 && nums[l - 1] < nums[l]) l--;
                while (r < n - 1 && nums[r + 1] < nums[r]) r++;
                ans = Math.max(ans, (r - l + 1));
            }
        }
        return ans;
    }
}