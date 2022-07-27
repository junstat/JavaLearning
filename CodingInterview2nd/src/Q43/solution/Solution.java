package Q43.solution;

public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        int ans = 0;
        for (long k = 1; k <= n; k *= 10) {
            long abc = n % k;
            long xyzd = n / k;
            long d = xyzd % 10;
            long xyz = (xyzd + 8) / 10;
            ans += xyz * k;
            if (d == 1) ans += abc + 1;
        }
        return ans;
    }
}
