package Q0499.Q0409LongestPalindrome;

import java.util.HashSet;
import java.util.Set;

/*
    回文串中包含的字符有两种情况
       a> 左右对称出现，出现了2次
       b> 对称中心，只出现1次
 */
public class Solution1 {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) return 0;
        Set<Character> hs = new HashSet<Character>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (hs.contains(s.charAt(i))) {
                hs.remove(s.charAt(i));
                count++;
            } else {
                hs.add(s.charAt(i));
            }
        }
        if (!hs.isEmpty()) return count * 2 + 1;
        return count * 2;
    }
}