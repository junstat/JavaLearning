package Q0099.Q0003LongestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.Set;

public class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (check(s, i, j)) result = Math.max(result, j - i);
            }
        }
        return result;
    }

    private boolean check(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            char c = s.charAt(i);
            if (set.contains(c)) return false;
            set.add(c);
        }
        return true;
    }
}
/*
    time complexity: 遍历字符两层循环 O(n^2), check函数O(n), 综合O(n^3)
    space complexity: O(n)
 */