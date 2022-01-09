package Q0099.Q0050Powxn;

import org.junit.Test;

/**
 * 方法一: 递归
 * case 1: 若 n为偶数，如 n=64
 * x ^ 64 = (x ^ 2) ^ 32 = (x ^ 4) ^ 16 = ...
 * case 2: 若 n为奇数，如 n=77
 * x ^ 77 = x * (x ^ 2) ^ 38 = ...
 * <p>
 * 通过逐步把幂次降低，直至收敛。
 */
public class Solution {

    @Test
    public void test1() {
        double x = 2.00000;
        int n = 1;
        System.out.println(myPow(x, n));
    }

    public double myPow(double x, int n) {
        long power = n;
        return power >= 0 ? myPowAux(x, power) : 1.0 / myPowAux(x, -power);
    }

    public double myPowAux(double x, long n) {
        if (n == 0) return 1;
        return (n % 2 == 0) ? myPowAux(x * x, n / 2) : x * myPowAux(x * x, n / 2);
    }
}
