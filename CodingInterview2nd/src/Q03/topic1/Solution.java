package Q03.topic1;

public class Solution {
    public int findRepeatNumber(int[] nums) {
        int n = nums.length;
        if (n <= 0) return -1;
        for (int i = 0; i < n; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) return nums[i];
                // swap nums[i] and nums[nums[i]]
                swap(nums, i, nums[i]);
            }
        }
        return 0;
    }

    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}