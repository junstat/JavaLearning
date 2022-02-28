package Q0399.Q0316RemoveDuplicateLetters;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/*
    [Medium]
    Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure
    your result is the smallest in lexicographical order among all possible results.

    Example 1:
    Input: s = "bcabc"
    Output: "abc"

    Example 2:
    Input: s = "cbacdcbc"
    Output: "acdb"
 */
public class Review {
    @Test
    public void test1() {
        String s = "cbacdcbc";
        String result = removeDuplicateLetters(s);
        assertEquals("acdb", result);
    }

    public String removeDuplicateLetters(String s) {

        return null;
    }
}
