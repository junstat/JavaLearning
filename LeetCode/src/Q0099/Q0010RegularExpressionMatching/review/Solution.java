package Q0099.Q0010RegularExpressionMatching.review;

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
public class Solution{
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

        return false;
    }
}
