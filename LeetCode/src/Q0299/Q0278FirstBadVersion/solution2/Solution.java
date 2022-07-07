package Q0299.Q0278FirstBadVersion.solution2;

public class Solution {
    public int firstBadVersion(int n) {
        int l = 1, r = n;
        while (l < r) {
            long tmp = (long) l + r >> 1;
            int mid = (int) tmp;
            if (isBadVersion(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    boolean isBadVersion(int i) {
        return false;
    }
}
