package Q0099.Q0003LongestSubstringWithoutRepeatingCharacters;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

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
  滑动窗口：在窗口中始终保存不重复的字母，求窗口的长度并更新到结果中
  start: 不重复子串中第1个字符在s中的下标
  end:   不重复子串中最后一个字符在s中的下标
  难点:
  更新start的时候 +1(lastOccurred中保存的是字符c在s中最后一次出现的下标，所以start应该是c后面一个字符，该+1。)
  更新res的时候 +1 (数轴上的两个不同点a, b之间的间隔数为(b - a)，可是，a,b间点的个数为(b - a + 1)。)
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
