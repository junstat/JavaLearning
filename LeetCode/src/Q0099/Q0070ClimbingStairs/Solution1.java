package Q0099.Q0070ClimbingStairs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution1 {
    @Test
    public void test1() {
        assertEquals(3, climbStairs(3));
        assertEquals(5, climbStairs(4));
        assertEquals(8, climbStairs(5));
    }

    public int climbStairs(int n) {
        return fib(n, 1, 1);
    }

    public int fib(int n, int a, int b) {
        if (n == 0) return a;
        return fib(n - 1, b, a + b);
    }
}
