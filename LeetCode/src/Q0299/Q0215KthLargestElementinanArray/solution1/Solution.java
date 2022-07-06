package Q0299.Q0215KthLargestElementinanArray.solution1;

import java.util.Arrays;

// Sort
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        return nums[n - k];
    }
}
