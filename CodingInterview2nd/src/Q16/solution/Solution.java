package Q16.solution;

public class Solution {
    public double Power(double x, int n) {
        double ans = 1;
        boolean neg = n < 0;
        n = neg ? -n : n;
        while (n > 0) {
            if ((n & 1) == 1) {
                ans = ans * x;
            }
            x = x * x;
            n >>= 1;
        }
        return neg ? 1 / ans : ans;
    }
}