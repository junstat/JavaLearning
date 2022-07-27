package Q48.solution;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] cs = s.toCharArray();
        int ans = 0, n = cs.length;
        for (int start = 0, end = 0; end < n; end++) {
            char right = cs[end];
            map.put(right, map.getOrDefault(right, 0) + 1);
            while (map.get(right) > 1) {
                char left = cs[start++];
                map.put(left, map.get(left) - 1);
            }
            ans = Math.max(ans, end - start + 1);
        }
        return ans;
    }
}

