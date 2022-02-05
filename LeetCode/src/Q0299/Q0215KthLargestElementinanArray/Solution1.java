package Q0299.Q0215KthLargestElementinanArray;

import java.util.Arrays;

// Sort
public class Solution1 {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        return nums[n - k];
    }
}
