package Q0299.Q0278FirstBadVersion.solution3;

public class Solution {
    public int firstBadVersion(int n) {
        int l = 1, r = n;
        while (l < r) {
            long tmp = (long) l + r + 1 >> 1;
            int mid = (int) tmp;
            if (!isBadVersion(mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return !isBadVersion(r) ? r + 1 : r;
    }

    boolean isBadVersion(int i) {
        return false;
    }
}