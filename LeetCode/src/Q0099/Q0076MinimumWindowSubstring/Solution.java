package Q0099.Q0076MinimumWindowSubstring;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
    Here is a 10-line template that can solve most 'substring' problems
    https://leetcode.com/problems/minimum-window-substring/discuss/26808/Here-is-a-10-line-template-that-can-solve-most-'substring'-problems

    1. Use two pointers: start and end to represent a window.
    2. Move end to find a valid window.
    3. When a valid window is found, move start to find a smaller window.
 */
public class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        for (int i = 0; i < t.length(); i++) map[t.charAt(i)]++;
        int counter = t.length(), begin = 0, end = 0, d = Integer.MAX_VALUE, head = 0;
        while (end < s.length()) {
            if (map[s.charAt(end++)]-- > 0) counter--;  // in t
            while (counter == 0) {  // valid
                if (end - begin < d) d = end - (head = begin);
                if (map[s.charAt(begin++)]++ == 0) counter++;   // make it invalid
            }
        }
        return d == Integer.MAX_VALUE ? "" : s.substring(head, head + d);
    }
}