package Q0099.Q0020ValidParentheses.review;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/*
  [Easy]
  Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
  determine if the input string is valid.

  An input string is valid if:
  Open brackets must be closed by the same type of brackets.
  Open brackets must be closed in the correct order.

  Example 1:
  Input: s = "()"
  Output: true

  Example 3:
  Input: s = "(]"
  Output: false
 */
public class Solution {
    @Test
    public void test1() {
        String s = "()[]{}";
        assertTrue(isValid(s));
    }

    @Test
    public void test2() {
        String s = "([)]";
        assertFalse(isValid(s));
    }

    public boolean isValid(String s) {

        return false;
    }
}
