package Q0299.Q0287FindTheDuplicateNumber.solution3;

public class Solution {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] - 1 != i) {
                if (nums[i] == nums[nums[i] - 1]) return nums[i];
                swap(nums, i, nums[i] - 1);
            }
        }
        return -1;
    }

    void swap(int[] nums, int a, int b) {
        int c = nums[a];
        nums[a] = nums[b];
        nums[b] = c;
    }
}