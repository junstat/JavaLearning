package Q0299.Q0275HIndexII.solution1;

public class Solution {
    public int hIndex(int[] cs) {
        int n = cs.length;
        int l = 0, r = n;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (check(cs, mid)) l = mid;
            else r = mid - 1;
        }
        return r;
    }
    boolean check(int[] cs, int mid) {
        int ans = 0;
        for (int i : cs) if (i >= mid) ans++;
        return ans >= mid;
    }
}
