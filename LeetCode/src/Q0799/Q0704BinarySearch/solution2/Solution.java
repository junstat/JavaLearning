package Q0799.Q0704BinarySearch.solution2;

public class Solution {
    public int search(int[] nums, int t) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= t) r = mid;
            else l = mid + 1;
        }
        return nums[r] == t ? r : -1;
    }
}