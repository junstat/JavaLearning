package Q0299.Q0278FirstBadVersion;

public class Solution {
    boolean isBadVersion(int version) {
        return false;
    }

    public int firstBadVersion(int n) {
        int lo = 1, hi = n;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (!isBadVersion(mid)) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}
