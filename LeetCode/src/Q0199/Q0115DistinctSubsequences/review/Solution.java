package Q0199.Q0115DistinctSubsequences.review;

import org.junit.Test;

/*
    [Hard]
    Given two strings s and t, return the number of distinct subsequences of s which equals t.
    A string's subsequence is a new string formed from the original string by deleting some (can be none) of the
    characters without disturbing the remaining characters' relative positions.
    (i.e., "ACE" is a subsequence of "ABCDE" while "AEC" is not).
    The test cases are generated so that the answer fits on a 32-bit signed integer.

    Example 1:
    Input: s = "rabbbit", t = "rabbit"
    Output: 3
    Explanation:
    As shown below, there are 3 ways you can generate "rabbit" from S.
    RABB b IT
    RA b BBIT
    RAB b BIT

    Example 2:
    Input: s = "babgbag", t = "bag"
    Output: 5
    Explanation:
    As shown below, there are 5 ways you can generate "bag" from S.
    BA b G bag
    BA bgba G
    B abgb AG
    ba B gb AG
    babg BAG
 */
public class Solution {

    @Test
    public void test1() {
        String s = "rabbbit", t = "rabbit";
        System.out.println(numDistinct(s, t));
    }

    public int numDistinct(String s, String t) {

        return 0;
    }
}
