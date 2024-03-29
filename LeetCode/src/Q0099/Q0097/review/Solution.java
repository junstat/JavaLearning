package Q0099.Q0097.review;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

/*
    [Medium]
    Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
    An interleaving of two strings s and t is a configuration where they are divided into
    non-empty substrings such that:
    s = s1 + s2 + ... + sn
    t = t1 + t2 + ... + tm
    |n - m| <= 1
    The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
    Note: a + b is the concatenation of strings a and b.

    Example 1:
    Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
    Output: true

    Example 2:
    Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
    Output: false

    Example 3:
    Input: s1 = "", s2 = "", s3 = ""
    Output: true
 */
public class Solution {
    @Test
    public void test1() {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        boolean result = isInterleave(s1, s2, s3);
        assertTrue(result);
    }

    public boolean isInterleave(String s1, String s2, String s3) {

        return false;
    }
}
