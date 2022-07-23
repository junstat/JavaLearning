package Q0599.Q0524LongestWordinDictionarythroughDeleting.solution;

import java.util.Collections;
import java.util.List;

public class Solution {
    public String findLongestWord(String s, List<String> list) {
        Collections.sort(list, (a, b) -> {
            if (a.length() != b.length()) return b.length() - a.length();
            return a.compareTo(b);
        });
        int n = s.length();
        for (String ss : list) {
            int m = ss.length();
            int i = 0, j = 0;
            while (i < n && j < m) {
                if (s.charAt(i) == ss.charAt(j)) j++;
                i++;
            }
            if (j == m) return ss;
        }
        return "";
    }
}