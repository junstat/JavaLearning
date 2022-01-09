package Q0099.Q0069sqrtx;


import org.junit.Test;

/**
 * A Binary Search Solution from wikipedia:
 * https://en.wikipedia.org/wiki/Integer_square_root
 */
public class Solution {

    @Test
    public void test1() {
        int x = 2147395599;
        System.out.println(Integer.MAX_VALUE);
    }

    public int mySqrt(int x) {
        if (x == 0) return 0;
        long lo = 0, hi = x;
        while (lo < hi) {
            long mid = (lo + hi + 1) / 2;
            if (mid * mid > x) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return (int) lo;
    }
}