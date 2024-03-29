package Q0099.Q0028.review;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
    [Easy]
    Implement strStr().
    Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
    Clarification:
    What should we return when needle is an empty string? This is a great question to ask during an interview.
    For the purpose of this problem, we will return 0 when needle is an empty string.
    This is consistent to C's strstr() and Java's indexOf().

    Example 1:
    Input: haystack = "hello", needle = "ll"
    Output: 2

    Example 2:
    Input: haystack = "aaaaa", needle = "bba"
    Output: -1

    Example 3:
    Input: haystack = "", needle = ""
    Output: 0
 */
public class Solution {
    @Test
    public void test1() {
        String haystack = "hello", needle = "ll";
        assertEquals(strStr(haystack, needle), 2);
    }

    @Test
    public void test2() {
        String haystack = "aaaaa", needle = "bba";
        assertEquals(strStr(haystack, needle), -1);
    }

    @Test
    public void test3() {
        String haystack = "mississippi", needle = "issip";
        assertEquals(strStr(haystack, needle), 4);
    }

    public int strStr(String ss, String pp) {

        return 0;
    }
}
