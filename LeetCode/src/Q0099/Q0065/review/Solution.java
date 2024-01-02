package Q0099.Q0065.review;

import org.junit.Test;

import static org.junit.Assert.*;

/*
    [Hard]
    A valid number can be split up into these components (in order):
    A decimal number or an integer.
    (Optional) An 'e' or 'E', followed by an integer.
    A decimal number can be split up into these components (in order):
    (Optional) A sign character (either '+' or '-').
    One of the following formats:
    One or more digits, followed by a dot '.'.
    One or more digits, followed by a dot '.', followed by one or more digits.
    A dot '.', followed by one or more digits.
    An integer can be split up into these components (in order):
    (Optional) A sign character (either '+' or '-').
    One or more digits.
    For example, all the following are valid numbers: ["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3",
    "3e+7", "+6e-1", "53.5e93", "-123.456e789"], while the following are not valid numbers:
    ["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"].

    Given a string s, return true if s is a valid number.

    Example 1:
    Input: s = "0"
    Output: true

    Example 2:
    Input: s = "e"
    Output: false

    Example 3:
    Input: s = "."
    Output: false
 */
public class Solution {
    @Test
    public void test1() {
        assertTrue(isNumber("+3.14"));
        assertTrue(isNumber("0089"));
        assertTrue(isNumber("2e10"));
        assertTrue(isNumber("2E10"));
        assertFalse(isNumber("95a54e53"));
        assertFalse(isNumber("99e2.5"));
    }

    @Test
    public void test3() {
        String s = "005047e+6";
        System.out.println(isNumber(s));
    }

    @Test
    public void test2() {
        String s = "1E9";
        System.out.println(isNumber(s));
    }

    public boolean isNumber(String s) {

        return false;
    }
}