package Q0099.Q0010RegularExpressionMatching;

import org.junit.Test;

/*
  [Hard]
  Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
  '.' Matches any single character.
  '*' Matches zero or more of the preceding element.
  The matching should cover the entire input string (not partial).

  Example 1:
  Input: s = "aa", p = "a"
  Output: false
  Explanation: "a" does not match the entire string "aa".

  Example 2:
  Input: s = "aa", p = "a*"
  Output: true
  Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".

  Example 3:
  Input: s = "ab", p = ".*"
  Output: true
  Explanation: ".*" means "zero or more (*) of any character (.)".
 */
public class Review {
    @Test
    public void test1() {
        String s = "aa";
        String p = "a";
        System.out.println(isMatch(s, p));
    }

    @Test
    public void test2() {
        // * 匹配0次
        String s = "ab";
        String p = "abc*";
        System.out.println(isMatch(s, p));
    }

    @Test
    public void test3() {
        // * 匹配1次
        String s = "abc";
        String p = "abc*";
        System.out.println(isMatch(s, p));
    }

    @Test
    public void test4() {
        // * 匹配2次
        String s = "abcc";
        String p = "abc*";
        System.out.println(isMatch(s, p));
    }

    @Test
    public void test5() {
        String s = "mississippi";
        String p = "mis*is*p*.";
        System.out.println(isMatch(s, p));
    }

    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) != '*') {
                    if (match(s, p, i, j)) dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 2];
                    if (match(s, p, i, j - 1)) dp[i][j] = dp[i][j] || dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }

    private boolean match(String s, String p, int i, int j) {
        if (i == 0) return false;
        if (p.charAt(j - 1) == '.') return true;
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
