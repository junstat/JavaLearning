package Q0099.Q0072EditDistance;

/*
    DP
    1. Define the state dp[i][j]
        to be the minimum number of operations to convert word1[0...i) to word2[0...j)
    2. Initial state
        For the base case, that is, to convert a string to an empty string, the minimum number of operations(deletions)
        is just the length of the string. So we have dp[i][0] = i and dp[0][j] = j.
    3. State transition equation
        For the general case to convert word1[0...i) to word2[0...j), we break this problem down into sub-problems.
        Suppose we have already known how to convert word1[0...i-1) to word2[0...j-1) i.e. dp[i-1][j-1],
        if word1[i-1] == word2[j-1], then no more operation is needed and dp[i][j] = dp[i-1][j-1]

        if word1[i-1] != word2[j-1], we need to consider three cases.
        a) Replace word1[i-1] by word2[j-1] i.e. dp[i][j] = dp[i-1][j-1] + 1
        b) if word1[0...i-1) = word2[0...j) then delete word1[i-1] i.e. dp[i][j] = dp[i-1][j] + 1
        c) if word1[0...i) + word2[j-1) = word2[0...j) then insert word2[j-1] to word1[0...i)
            i.e. dp[i][j] = dp[i][j-1] + 1
    So when word1[i-1] != word2[j-1], dp[i][j] will just be the minimum of the above three case
*/
public class Solution1 {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) dp[i][0] = i;
        for (int j = 1; j <= n; j++) dp[0][j] = j;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
            }
        }
        return dp[m][n];
    }
}