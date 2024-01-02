package Q0099.Q0072.review;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/*
    [Hard]
    Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
    You have the following three operations permitted on a word:
    Insert a character
    Delete a character
    Replace a character

    Example 1:
    Input: word1 = "horse", word2 = "ros"
    Output: 3
    Explanation:
    horse -> rorse (replace 'h' with 'r')
    rorse -> rose (remove 'r')
    rose -> ros (remove 'e')

    Example 2:
    Input: word1 = "intention", word2 = "execution"
    Output: 5
    Explanation:
    intention -> inention (remove 't')
    inention -> enention (replace 'i' with 'e')
    enention -> exention (replace 'n' with 'x')
    exention -> exection (replace 'n' with 'c')
    exection -> execution (insert 'u')
 */
public class Solution {
    @Test
    public void test1() {
        String word1 = "horse";
        String word2 = "ros";
        assertEquals(3, minDistance(word1, word2));
    }

    public int minDistance(String word1, String word2) {

        return 0;
    }
}
