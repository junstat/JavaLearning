package Q0099.Q0007.review;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/*
    [Medium]
    Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside
    the signed 32-bit integer range [-231, 231 - 1], then return 0.
    Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

    Example 1:
    Input: x = 123
    Output: 321

    Example 2:
    Input: x = -123
    Output: -321

    Example 3:
    Input: x = 120
    Output: 21
 */
public class Solution{
    @Test
    public void test1() {
        int x = -123;
        int result = reverse(x);
        assertEquals(-321, result);
    }

    @Test
    public void test2() {
        int x = 123;
        int result = reverse(x);
        assertEquals(321, result);
    }

    @Test
    public void test3() {
        int x = Integer.MAX_VALUE; // 2147483647
        assertEquals(0, reverse(x));
    }

    public int reverse(int x) {

        return 0;
    }
}
