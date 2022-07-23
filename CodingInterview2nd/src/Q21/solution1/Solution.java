package Q21.solution1;

public class Solution {
    public int[] reOrderArray(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            while (l < r && (nums[l] & 1) == 1) l++;
            while (l < r && (nums[r] & 1) == 0) r--;
            if (l < r) swap(nums, l++, r--);
        }
        return nums;
    }

    void swap(int[] nums, int i, int j) {
        int c = nums[i];
        nums[i] = nums[j];
        nums[j] = c;
    }
}
