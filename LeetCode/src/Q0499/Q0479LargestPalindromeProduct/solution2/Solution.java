package Q0499.Q0479LargestPalindromeProduct.solution2;

public class Solution {
    public int largestPalindrome(int n) {
        if (n > 1) {
            int upper = (int) Math.pow(10, n);
            for (long x = 2; x < upper; x += 2) {
                long high = upper - x;
                long low = Long.parseLong(new StringBuilder(Long.toString(high)).reverse().toString());
                long delta = x * x - 4 * low;
                if (delta < 0) continue;
                long sqrt = (long) Math.sqrt(delta);
                if (sqrt * sqrt == delta) return (int) ((high * upper + low) % 1337);
            }
        }
        return 9;
    }
}