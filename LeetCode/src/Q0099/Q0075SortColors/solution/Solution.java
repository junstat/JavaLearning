package Q0099.Q0075SortColors.solution;

public class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) return;
        int lo = 0, hi = nums.length - 1;
        int i = 0;
        while (i <= hi) {
            if (nums[i] == 0) {
                swap(nums, i, lo);
                i++;
                lo++;
            } else if (nums[i] == 2) {
                swap(nums, i, hi);
                hi--;
            } else i++;
        }
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}