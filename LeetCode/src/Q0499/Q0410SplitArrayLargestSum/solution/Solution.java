package Q0499.Q0410SplitArrayLargestSum.solution;

public class Solution {
    public int splitArray(int[] nums, int m) {
        int lo = Integer.MIN_VALUE, hi = 0;
        for (int num : nums) {
            hi += num;
            lo = Math.max(lo, num);
        }
        while (lo < hi) {
            int mid = (hi - lo) / 2 + lo;
            if (check(nums, mid, m)) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    public boolean check(int[] nums, int x, int m) {
        int sum = 0, cnt = 1;
        for (int num : nums) {
            if (sum + num > x) {
                cnt++;
                sum = num;
            } else {
                sum += num;
            }
        }
        return cnt <= m;
    }
}
