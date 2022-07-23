package Q10.solution2;

public class Solution {
    public int Fibonacci(int n) {
        return fib(n, 0, 1);
    }

    int fib(int n, int a, int b) {
        if (n == 1) return b;
        return fib(n - 1, b, a + b);
    }
}
