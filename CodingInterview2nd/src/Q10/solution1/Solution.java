package Q10.solution1;

public class Solution {
    public int Fibonacci(int n) {
        int a = 1, b = 1;
        while (n-- > 0) a = (b += a) - a;
        return a;
    }
}
