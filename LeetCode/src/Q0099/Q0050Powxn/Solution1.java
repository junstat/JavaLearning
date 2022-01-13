package Q0099.Q0050Powxn;

/**
 * 沿用方法一的思想，迭代实现
 */
public class Solution1 {

    public double myPow(double x, int n) {
        long power = n;
        if (power == 0) return 1;
        if (power < 0) {
            power = -power;
            x = 1 / x;
        }
        double ans = 1.0, increment = x;
        while (power > 0) {
            if (power % 2 == 1) ans *= increment;
            increment *= increment;
            power /= 2;
        }
        return ans;
    }
}
