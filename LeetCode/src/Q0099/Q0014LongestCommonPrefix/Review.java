package Q0099.Q0014LongestCommonPrefix;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/*
    [Easy]
    Write a function to find the longest common prefix string amongst an array of strings.
    If there is no common prefix, return an empty string "".

    Example 1:
    Input: strs = ["flower","flow","flight"]
    Output: "fl"

    Example 2:
    Input: strs = ["dog","racecar","car"]
    Output: ""
    Explanation: There is no common prefix among the input strings.
 */
public class Review {
    @Test
    public void test1() {
        String[] strs = {"flower", "flow", "flight"};
        assertEquals("fl", longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {

        return null;
    }
}
