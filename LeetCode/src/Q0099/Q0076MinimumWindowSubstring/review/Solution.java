package Q0099.Q0076MinimumWindowSubstring.review;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
    [Hard]
    Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every
    character in t (including duplicates) is included in the window.
    If there is no such substring, return the empty string "".
    The testcases will be generated such that the answer is unique.
    A substring is a contiguous sequence of characters within the string.

    Example 1:
    Input: s = "ADOBECODEBANC", t = "ABC"
    Output: "BANC"
    Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

    Example 2:
    Input: s = "a", t = "a"
    Output: "a"
    Explanation: The entire string s is the minimum window.

    Example 3:
    Input: s = "a", t = "aa"
    Output: ""
    Explanation: Both 'a's from t must be included in the window.
    Since the largest window of s only has one 'a', return empty string.
 */
public class Solution {

    @Test
    public void test1() {
        String s = "ADOBECODEBANC", t = "ABC";
        String expected = "BANC";
        String result = minWindow(s, t);
        assertEquals(expected, result);
    }

    public String minWindow(String s, String t) {

        return null;
    }
}