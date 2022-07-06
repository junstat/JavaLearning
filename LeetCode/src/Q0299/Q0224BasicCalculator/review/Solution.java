package Q0299.Q0224BasicCalculator.review;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/*
    [Hard]
    Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the
    result of the evaluation.
    Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such
    as eval().

    Example 1:
    Input: s = "1 + 1"
    Output: 2

    Example 2:
    Input: s = " 2-1 + 2 "
    Output: 3

    Example 3:
    Input: s = "(1+(4+5+2)-3)+(6+8)"
    Output: 23
 */
public class Solution{
    @Test
    public void test1() {
        assertEquals(2, calculate("1 + 1"));
        assertEquals(3, calculate("  2-1 + 2 "));
        assertEquals(23, calculate("(1+(4+5+2)-3)+(6+8)"));
    }

    public int calculate(String s) {

        return 0;
    }
}
