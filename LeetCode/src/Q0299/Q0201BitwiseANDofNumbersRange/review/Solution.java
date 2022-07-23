package Q0299.Q0201BitwiseANDofNumbersRange.review;

import org.junit.Test;

/*
    [Medium]
    Given two integers left and right that represent the range [left, right], return the bitwise AND of all numbers
    in this range, inclusive.

    Example 1:
    Input: left = 5, right = 7
    Output: 4

    Example 2:
    Input: left = 0, right = 0
    Output: 0

    Example 3:
    Input: left = 1, right = 2147483647
    Output: 0
 */
public class Solution {
    @Test
    public void test1() {
        System.out.println(rangeBitwiseAnd(26, 30)); // 24
    }

    @Test
    public void test2() {
        int m = 18, n = 30;
        System.out.println(rangeBitwiseAnd(m, n));  // 16
    }

    public int rangeBitwiseAnd(int left, int right) {

        return 0;
    }
}
