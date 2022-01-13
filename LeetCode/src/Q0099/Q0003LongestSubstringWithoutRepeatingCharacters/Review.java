package Q0099.Q0003LongestSubstringWithoutRepeatingCharacters;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
  [Medium]
  Given a string s, find the length of the longest substring without repeating characters.

  Example 1:
  Input: s = "abcabcbb"
  Output: 3
  Explanation: The answer is "abc", with the length of 3.

  Example 2:
  Input: s = "bbbbb"
  Output: 1
  Explanation: The answer is "b", with the length of 1.

  Example 3:
  Input: s = "pwwkew"
  Output: 3
  Explanation: The answer is "wke", with the length of 3.
  Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

  思路: 如果出现重复字符，更新start。
*/
public class Review {

    @Test
    public void test1() {
        String s = "abcabcbb";
        assertEquals(3, lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {

        return 0;
    }
}
