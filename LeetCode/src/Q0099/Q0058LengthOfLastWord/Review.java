package Q0099.Q0058LengthOfLastWord;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/*
    [Easy]
    Given a string s consisting of some words separated by some number of spaces,
    return the length of the last word in the string.
    A word is a maximal substring consisting of non-space characters only.

    Example 1:
    Input: s = "Hello World"
    Output: 5
    Explanation: The last word is "World" with length 5.

    Example 2:
    Input: s = "   fly me   to   the moon  "
    Output: 4
    Explanation: The last word is "moon" with length 4.

    Example 3:
    Input: s = "luffy is still joyboy"
    Output: 6
    Explanation: The last word is "joyboy" with length 6.
 */
public class Review {
    @Test
    public void test1() {
        String s = "   fly me   to   the moon  ";
        int expected = 4;
        assertEquals(expected, lengthOfLastWord(s));
    }

    public int lengthOfLastWord(String s) {
        return 0;
    }
}
