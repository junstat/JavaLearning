package Q53.solution;

public class Solution {
    int[] nums;
    int t, n;

    public int GetNumberOfK(int[] _nums, int _t) {
        nums = _nums;
        t = _t;
        if (nums == null || nums.length == 0) return 0;
        n = nums.length;
        if (n > 1 && nums[0] == nums[n - 1] && nums[0] == t) return n;
        int start = getFirstT();
        if (start == -1) return 0;
        int end = getLastT();
        return end - start + 1;
    }

    int getFirstT() {
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= t) r = mid;
            else l = mid + 1;
        }
        return nums[r] == t ? r : -1;
    }

    int getLastT() {
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] <= t) l = mid;
            else r = mid - 1;
        }
        return nums[l] == t ? l : -1;
    }
}