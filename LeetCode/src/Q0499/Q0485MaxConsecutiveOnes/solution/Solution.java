package Q0499.Q0485MaxConsecutiveOnes.solution;

public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0, j = 0; i < n; j = i) {
            if (nums[i] == 1) {
                while (j + 1 < n && nums[j + 1] == 1) j++;
                ans = Math.max(ans, j - i + 1);
                i = j + 1;
            } else {
                i++;
            }
        }
        return ans;
    }
}