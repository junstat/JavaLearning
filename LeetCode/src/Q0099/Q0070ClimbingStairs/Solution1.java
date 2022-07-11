package Q0099.Q0070ClimbingStairs;

public class Solution1 {

    public int climbStairs(int n) {
        return fib(n, 1, 1);
    }

    public int fib(int n, int a, int b) {
        if (n == 0) return a;
        return fib(n - 1, b, a + b);
    }
}
