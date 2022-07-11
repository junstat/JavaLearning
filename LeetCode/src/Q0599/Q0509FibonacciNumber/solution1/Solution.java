package Q0599.Q0509FibonacciNumber.solution1;

public class Solution {
    public int fib(int n) {
        int a = 0, b = 1;
        while (n-- > 0)
            a = (b += a) - a;
        return a;
    }
}
