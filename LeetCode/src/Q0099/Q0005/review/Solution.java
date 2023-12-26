package Q0099.Q0005.review;

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
*/
public class Solution {

    @Test
    public void test1() {
        String s = "babad";
        assertEquals("bab", longestPalindrome(s));
    }

    @Test
    public void test2() {
        String s = "aaaa";
        assertEquals("aaaa", longestPalindrome(s));
    }

    public String longestPalindrome(String s) {

        return null;
    }
}