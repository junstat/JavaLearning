package Q0299.Q0238ProductofArrayExceptSelf.solution2;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 1, j = 1; i <= n; i++) {
            ans[i - 1] = j;
            j *= nums[i - 1];
        }
        for (int i = n, j = 1; i >= 1; i--) {
            ans[i - 1] *= j;
            j *= nums[i - 1];
        }
        return ans;
    }
}