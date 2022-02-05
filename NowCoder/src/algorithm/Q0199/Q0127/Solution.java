package algorithm.Q0199.Q0127;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/*
    DP
    1) 状态定义
        dp[i][j] 表示字符串s1中第i个字符和s2中第j个字符所构成的最长公共子串。
    2) 初始状态
        dp[i][j] = {0}
    3) 状态转移方程
        dp[i][j] = 0, if s1[i] != s2[j]
        dp[i][j] = dp[i-1][j-1] + 1, if s1[i] == s2[j]
 */
public class Solution {

    @Test
    public void test1() {
        String s1 = "1AB2345CD", s2 = "12345EF", expected = "2345";
        assertEquals(expected, LCS(s1, s2));
    }

    /**
     * longest common substring
     *
     * @param s1 string字符串 the string
     * @param s2 string字符串 the string
     * @return string字符串
     */
    public String LCS(String s1, String s2) {
        // write code here
        int maxLen = 0;
        int end = 0;
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    if (dp[i + 1][j + 1] > maxLen) {
                        maxLen = dp[i + 1][j + 1];
                        end = i;
                    }
                }
            }
        }
        return s1.substring(end - maxLen + 1, end + 1);
    }
}
/*
    time complexity: 两层循环，O(n^2)
    space complexity: 二维数组，O(n^2)
 */
