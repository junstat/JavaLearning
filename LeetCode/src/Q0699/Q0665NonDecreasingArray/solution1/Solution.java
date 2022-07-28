package Q0699.Q0665NonDecreasingArray.solution1;

public class Solution {
    public boolean checkPossibility(int[] nums) {
        int n = nums.length, r = n - 2;
        for (; r >= 0 && nums[r] <= nums[r + 1]; --r) ;
        for (int i = 0; i < n; i++) {
            if ((i == 0 || i == n - 1 || nums[i + 1] >= nums[i - 1]) && i >= r) return true;
            if (i - 1 >= 0 && nums[i] < nums[i - 1]) break;
        }
        return false;
    }
}
