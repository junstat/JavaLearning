package Q0399.Q0342PowerofFour.solution1;

public class Solution {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) return false;
        int x = getVal(n);
        return x * x == n && (x & -x) == x;
    }

    int getVal(int n) {
        long l = 0, r = n;
        while (l < r) {
            long mid = l + r >> 1;
            if (mid * mid >= n) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return (int) r;
    }
}