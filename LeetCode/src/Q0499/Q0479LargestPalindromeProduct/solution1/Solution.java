package Q0499.Q0479LargestPalindromeProduct.solution1;

public class Solution {
    public int largestPalindrome(int n) {
        if (n == 1) return 9;
        int upper = (int) Math.pow(10, n) - 1;
        int ans = 0;
        for (int start = upper; ans == 0; --start) {  // 枚举回文数的左半部分
            long p = start;
            for (int x = start; x > 0; x /= 10) p = p * 10 + x % 10; // 翻转左半部分到其自身末尾，构造回文数p
            for (long x = upper; x * x >= p; --x)
                if (p % x == 0) { // x是p的因子
                    ans = (int) (p % 1337);
                    break;
                }
        }
        return ans;
    }
}