package Q0399.Q0396RotateFunction.solution1;

public class Solution {
    public int maxRotateFunction(int[] nums) {
        int tot = 0, n = nums.length, F = 0;
        for (int i = 0; i < n; i++) {
            F += i * nums[i];
            tot += nums[i];
        }
        int ans = F;
        for (int i = n - 1; i >= 1; i--) {
            F = F + tot - n * nums[i];
            ans = Math.max(ans, F);
        }
        return ans;
    }
}
