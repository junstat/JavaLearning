package Q0199.Q0166FractiontoRecurringDecimal.review;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/*
    [Medium]
    Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
    If the fractional part is repeating, enclose the repeating part in parentheses.
    If multiple answers are possible, return any of them.
    It is guaranteed that the length of the answer string is less than 104 for all the given inputs.

    Example 1:
    Input: numerator = 1, denominator = 2
    Output: "0.5"

    Example 2:
    Input: numerator = 2, denominator = 1
    Output: "2"

    Example 3:
    Input: numerator = 4, denominator = 333
    Output: "0.(012)"
 */
public class Solution {
    @Test
    public void test1() {
        assertEquals("0.0000000004656612873077392578125", fractionToDecimal(-1, -2147483648));
        assertEquals("0.(012)", fractionToDecimal(4, 333));
    }

    public String fractionToDecimal(int numerator, int denominator) {

        return null;
    }
}
