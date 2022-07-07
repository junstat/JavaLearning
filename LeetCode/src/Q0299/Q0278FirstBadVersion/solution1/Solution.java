package Q0299.Q0278FirstBadVersion.solution1;

public class Solution {
    public int firstBadVersion(int n) {
        int lo = 1, hi = n;
        while (lo < hi) {   // 直到lo, hi重合退出循环
            int mid = lo + (hi - lo) / 2;
            if (!isBadVersion(mid)) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    boolean isBadVersion(int i) {
        return false;
    }
}