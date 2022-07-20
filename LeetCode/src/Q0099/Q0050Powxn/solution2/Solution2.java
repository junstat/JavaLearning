package Q0099.Q0050Powxn.solution2;

/*

 */
public class Solution2 {
    public double myPow(double x, int n) {
        double ans = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                ans = ans * x;
            }
            x = x * x;
            n >>= 1;
        }
        return ans;
    }
}