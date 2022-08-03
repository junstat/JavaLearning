package Q0099.Q0075SortColors.solution;

public class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) return;
        int n = nums.length, l = 0, r = n - 1;
        int i = 0;
        while (i <= r) {
            if (nums[i] == 0) swap(nums, i++, l++);
            else if (nums[i] == 2) swap(nums, i, r--);
            else i++;
        }
    }

    void swap(int[] nums, int a, int b) {
        int c = nums[a];
        nums[a] = nums[b];
        nums[b] = c;
    }
}