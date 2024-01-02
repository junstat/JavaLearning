package Q0099.Q0069.solution2;

/**
 * Algorithm using Newton's method, from wikipedia
 * https://en.wikipedia.org/wiki/Integer_square_root
 */
public class Solution {
    public int mySqrt(int x) {
        long n = x;
        while (n * n > x)
            n = (n + x / n) / 2;
        return (int) n;
    }
}
