package Q0099.Q0005LongestPalindromicSubstring;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
  [Medium]
  Given a string s, return the longest palindromic substring in s.

  Example 1:
  Input: s = "babad"
  Output: "bab"
  Explanation: "aba" is also a valid answer.

  Example 2:
  Input: s = "cbbd"
  Output: "bb"

  DP
  1. 状态定义
    boolean dp[i][j] = s[i, ..., j] is palindromic
  2. 初始条件
    boolean dp[0][0] = true 1   1个字符认为是回文的
  3. 状态转移方程
    若 j - i = 0, dp[i][j] = true       1个字符认为是回文的
    若 j - i = 1, dp[i][j] = s[i] == s[j]  2个字符相等即可
    若 j - i = 2, dp[i][j] = s[i] == s[j]  首尾相同即可
    ==> dp[i][j] = s[i] == s[j] && (j - i <= 2)  ------ 1.

    若 j - i > 2，dp[i][j] = s[i] == s[j] && dp[i+1][j-1]
    ==> dp[i][j] = s[i] == s[j] && dp[i+1][j-1] && (j - i > 2)  ------ 2.
    联立 1. 2.
    ==> dp[i][j] = s[i] == s[j] && (
        (j - i <= 2) || dp[i+1][j-1]
    )
*/
public class Review {

    @Test
    public void test1() {
        String s = "babad";
        assertEquals("bab", longestPalindrome(s));
    }

    public String longestPalindrome(String s) {

        return null;
    }
}