package Q0199.Q0162FindPeakElement.solution1;

public class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            boolean ok = true;
            if (i - 1 >= 0) {
                if (nums[i - 1] >= nums[i]) ok = false;
            }
            if (i + 1 < n) {
                if (nums[i + 1] >= nums[i]) ok = false;
            }
            if (ok) return i;
        }
        return -1;
    }
}