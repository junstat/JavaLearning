package Q0099.Q0022GenerateParentheses.review;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/*
    [Medium]
    Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

    Example 1:
    Input: n = 3
    Output: ["((()))","(()())","(())()","()(())","()()()"]

    Example 2:
    Input: n = 1
    Output: ["()"]
 */
public class Solution {
    @Test
    public void test1() {
        int n = 3;
        String[] expected = {"((()))", "(()())", "(())()", "()(())", "()()()"};
        List<String> expectedList = new ArrayList<>(Arrays.asList(expected));
        assertEquals(expectedList, generateParenthesis(n));
    }

    public List<String> generateParenthesis(int n) {

        return null;
    }
}
