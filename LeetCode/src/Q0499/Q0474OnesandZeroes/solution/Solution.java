package Q0499.Q0474OnesandZeroes.solution;

public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        int numZeroes, numOnes;
        for (String s : strs) {
            numZeroes = numOnes = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '0') numZeroes++;
                else if (c == '1') numOnes++;
            }

            for (int i = m; i >= numZeroes; i--) {
                for (int j = n; j >= numOnes; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - numZeroes][j - numOnes] + 1);
                }
            }
        }
        return dp[m][n];
    }
}