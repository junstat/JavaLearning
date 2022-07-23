package Q0599.Q0540SingleElementinaSortedArray.solution3;

public class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] == nums[mid ^ 1]) l = mid + 1;
            else r = mid;
        }
        return nums[r];
    }
}