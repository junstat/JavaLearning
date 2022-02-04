package Q0299.Q0209MinimumSizeSubarraySum;

/*
    O(NLogN) - search if a window of size k exists that satisfy the condition
 */
public class Solution2 {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 1, j = nums.length, min = 0;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (windowExist(mid, nums, target)) {
                j = mid - 1;
                min = mid;
            } else i = mid + 1;
        }
        return min;
    }

    private boolean windowExist(int size, int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i >= size) sum -= nums[i - size];
            sum += nums[i];
            if (sum >= target) return true;
        }
        return false;
    }
}
