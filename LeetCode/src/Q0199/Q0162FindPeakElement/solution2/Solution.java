package Q0199.Q0162FindPeakElement.solution2;

public class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] > nums[mid + 1]) r = mid;
            else l = mid + 1;
        }
        return r;
    }
}


class Other {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] > nums[mid - 1]) l = mid;
            else r = mid - 1;
        }
        return r;
    }
}