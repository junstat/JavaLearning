package Q0199.Q0132PalindromePartitioningII;

import java.util.stream.IntStream;

public class Solution {
    public int minCut(String s) {
        // corner case
        if (s == null || s.length() <= 1) return 0;

        // dp
        int n = s.length();
        int[] dp = IntStream.range(0, n).toArray(); // initial value: dp[i] = i

        for (int mid = 1; mid < n; mid++) {     // iterate through all chars as mid point of palindrome
            // CASE 1. odd len, center is at index mid, expand on both sides
            for (int start = mid, end = mid; start >= 0 && end < n && s.charAt(start) == s.charAt(end);
                 start--, end++) {
                int newCutAtEnd = (start == 0) ? 0 : dp[start - 1] + 1;
                dp[end] = Math.min(dp[end], newCutAtEnd);
            }

            // CASE 2: even len, center is between [mid-1, mid], expand on both sides
            for (int start = mid - 1, end = mid; start >= 0 && end < n && s.charAt(start) == s.charAt(end);
                 start--, end++) {
                int newCutAtEnd = (start == 0) ? 0 : dp[start - 1] + 1;
                dp[end] = Math.min(dp[end], newCutAtEnd);
            }
        }
        return dp[n - 1];
    }
}
